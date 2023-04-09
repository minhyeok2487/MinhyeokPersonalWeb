package MH.domain.lostark.service;

import MH.domain.lostark.dto.LostarkMarketItemDto;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItemRepository;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LostarkMarketItemService {

	private final LostarkMarketItemRepository lostarkMarketItemRepository;

	@Transactional
	public void save(LostarkMarketItemDto lostarkMarketItemDto) {
		LostarkMarketItem lostarkMarketItem = lostarkMarketItemRepository.findByName(lostarkMarketItemDto.getName());
		if(lostarkMarketItem != null) {
			lostarkMarketItem.setYDayAvgPrice(lostarkMarketItemDto.getYDayAvgPrice());
			lostarkMarketItem.setRecentPrice(lostarkMarketItemDto.getRecentPrice());
			lostarkMarketItem.setCurrentMinPrice(lostarkMarketItemDto.getCurrentMinPrice());
			lostarkMarketItemRepository.save(lostarkMarketItem);
		} else {
			lostarkMarketItemRepository.save(lostarkMarketItemDto.toEntity());
		}

	}

	public List<LostarkMarketItem> getMarketItems() {
		List<LostarkMarketItem> allData = lostarkMarketItemRepository.findAll();
		return allData;
	}
}
