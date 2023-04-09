package MH.domain.restaurant.service;

import MH.domain.restaurant.entity.Restaurant;
import MH.domain.restaurant.entity.RestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import MH.domain.restaurant.dto.PositionDto;
import MH.domain.restaurant.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;

	public List<Restaurant> getData() {
		List<Restaurant> data = restaurantRepository.findByXIsNotNullAndYIsNotNull();
		return data;
	}

	public List<Restaurant> getAllData() {
		List<Restaurant> data = restaurantRepository.findAll();
		return data;
	}

	public Optional<Restaurant> getIdData(int id) {
		return restaurantRepository.findById(id);
	}

	@Transactional
	public Restaurant editData(RestaurantDto restaurantDto) {
		Restaurant restaurant = restaurantRepository.findById(restaurantDto.getId()).orElseThrow(() -> new IllegalArgumentException());
		restaurant.setMenu(restaurantDto.getMenu());
		restaurant.setReview(restaurantDto.getReview());
		restaurant.setTakeout(restaurantDto.getTakeout());
		if(restaurantDto.getX() != null) {
			restaurant.setX(restaurantDto.getX());
		}
		if(restaurantDto.getY() != null) {
			restaurant.setY(restaurantDto.getY());
		}
		if(restaurantDto.getKakaoUrl() != null) {
			restaurant.setKakaoUrl(restaurantDto.getKakaoUrl());
		}
		if(restaurantDto.getNaverUrl() != null) {
			restaurant.setNaverUrl(restaurantDto.getNaverUrl());
		}
		return restaurant;
	}

	public List<PositionDto> getPosition(List<Restaurant> data) {
		List<PositionDto> positions = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			PositionDto positionDto = new PositionDto();
			positionDto.setId(data.get(i).getId());
			positionDto.setX(data.get(i).getX());
			positionDto.setY(data.get(i).getY());
			String content = String.format("<div style=\"width:180px; background:#dddddd; text-align:center;\"><span style=\"font-weight:bold\">%s</span>", data.get(i).getName());
			if(data.get(i).getKakaoUrl() != null) {
				String kakaoUrl = String.format("<br><a href=\"%s\" style=\"color:yellow\" target=\"_blank\">카카오 검색</a>", data.get(i).getKakaoUrl());
				content += kakaoUrl;
			}
			if(data.get(i).getNaverUrl() != null) {
				String naverUrl = String.format("<br><a href=\"%s\" style=\"color:green\" target=\"_blank\">네이버 검색</a>", data.get(i).getNaverUrl());
				content += naverUrl;
			}
			content += "</div>";
			positionDto.setContent(content);
			positions.add(positionDto);
		}
		return positions;
	}
}
