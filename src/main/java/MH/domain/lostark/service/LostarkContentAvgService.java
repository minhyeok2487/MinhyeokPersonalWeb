package MH.domain.lostark.service;

import MH.domain.lostark.dto.LostarkContentAvgDto;
import MH.domain.lostark.entity.lostarkContentAvg.LostarkContentAvg;
import MH.domain.lostark.entity.lostarkContentAvg.LostarkContentRepository;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItem;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItemRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LostarkContentAvgService {

	private final LostarkContentRepository chaosAvgRepository;
	private final LostarkMarketItemRepository marketItemRepository;
	private final LostarkAuctionApiService auctionApiService;

	// 휴게 포함 일일 컨텐츠 비교 계산
	public List<LostarkContentAvgDto> contentAvgTotal(List<LostarkContentAvgDto> contentAvgDtos) {
		List<LostarkContentAvgDto> contentAvgTotalDtos = new ArrayList<>();
		for (LostarkContentAvgDto contentAvgDto : contentAvgDtos) {
			String name = contentAvgDto.getName();
			for (int i = 0; i < 3; i++) {
				LostarkContentAvgDto lostarkContentAvgDto = new LostarkContentAvgDto();
				lostarkContentAvgDto.setLevel(contentAvgDto.getLevel());
				lostarkContentAvgDto.setCategory(contentAvgDto.getCategory());
				if(i == 0) {
					lostarkContentAvgDto.setName(name+" 1수");
					lostarkContentAvgDto.setAvailablePrice(contentAvgDto.getAvailablePrice());
				}
				if(i == 1) {
					lostarkContentAvgDto.setName(name+" 2수");
					lostarkContentAvgDto.setAvailablePrice(contentAvgDto.getAvailablePrice() * 2);
				}
				if(i == 2) {
					lostarkContentAvgDto.setName(name+" 휴게 2수");
					lostarkContentAvgDto.setAvailablePrice(contentAvgDto.getAvailablePrice() * 4);
				}
				contentAvgTotalDtos.add(lostarkContentAvgDto);
			}
		}
		return sortAvg(contentAvgTotalDtos);
	}


	// 일일 컨텐츠(카오스 던전, 가디언 토벌 가져오기)
	public List<LostarkContentAvgDto> contentAvg() {
		List<LostarkContentAvg> contentAvgs = chaosAvgRepository.findAll();
		List<LostarkContentAvgDto> contentAvgDtos = new ArrayList<>();
		JSONArray jewelryArray = (JSONArray) auctionApiService.AuctionItems(210000, "1레벨").get("Items");
		JSONObject jewelryObject = (JSONObject) jewelryArray.get(0);
		JSONObject jewelry = (JSONObject) jewelryObject.get("AuctionInfo");

		for (int i = 0; i < contentAvgs.size(); i++) {
			int level = contentAvgs.get(i).getLevel();
			double desPrice = 0;
			double guaPrice = 0;
			double leapPrice = 0;
			LostarkContentAvgDto contentAvgDto = new LostarkContentAvgDto();
			if(level >= 1580) {
				// 정제된 파괴강석, 정제된 수호강석, 찬란한 명예의 돌파석
				desPrice = calMarket("정제된 파괴강석", contentAvgs.get(i).getDestructionStone());
				guaPrice = calMarket("정제된 수호강석", contentAvgs.get(i).getGuardianStone());
				leapPrice = calMarket("찬란한 명예의 돌파석", contentAvgs.get(i).getLeapStone());
			} else if(level >= 1490 && level < 1580) {
				// 파괴강석, 수호강석, 경이로운 명예의 돌파석
				desPrice = calMarket("파괴강석", contentAvgs.get(i).getDestructionStone());
				guaPrice = calMarket("수호강석", contentAvgs.get(i).getGuardianStone());
				leapPrice = calMarket("경이로운 명예의 돌파석", contentAvgs.get(i).getLeapStone());
			} else if(level < 1490){
				// 파괴석 결정, 수호석 결정, 위대한 명예의 돌파석
				desPrice = calMarket("파괴석 결정", contentAvgs.get(i).getDestructionStone());
				guaPrice = calMarket("수호석 결정", contentAvgs.get(i).getGuardianStone());
				leapPrice = calMarket("위대한 명예의 돌파석", contentAvgs.get(i).getLeapStone());
			}

			double availablePrice = desPrice+guaPrice;
			if(contentAvgs.get(i).getCategory().equals("카오스 던전")) {
				availablePrice += Double.parseDouble(jewelry.get("BuyPrice").toString()) * contentAvgs.get(i).getJewelry();
				availablePrice += contentAvgs.get(i).getGold();
			} else {
				availablePrice += leapPrice;
			}
			availablePrice = Math.round(availablePrice * 100.0) / 100.0;
			contentAvgDto.setLevel(level);
			contentAvgDto.setCategory(contentAvgs.get(i).getCategory());
			contentAvgDto.setName(contentAvgs.get(i).getName());
			contentAvgDto.setAvailablePrice(availablePrice);
			contentAvgDtos.add(contentAvgDto);
		}
		return sortAvg(contentAvgDtos);
	}

	// 재료 이름과 갯수 넣으면 가격 리턴
	public double calMarket(String itemName, double count) {
		LostarkMarketItem itemDto = marketItemRepository.findByName(itemName);
		double price = (itemDto.getRecentPrice() * count) / itemDto.getBundleCount();
		return Math.round(price * 100.0) / 100.0;
	}

	// 수익순으로 정렬
	public List<LostarkContentAvgDto> sortAvg(List<LostarkContentAvgDto> contentAvgDtos) {
		Collections.sort(contentAvgDtos, new Comparator<LostarkContentAvgDto>() {
			@Override
			public int compare(LostarkContentAvgDto o1, LostarkContentAvgDto o2) {
				return Double.compare(o2.getAvailablePrice(), o1.getAvailablePrice());
			}
		});
		return contentAvgDtos;
	}

}
