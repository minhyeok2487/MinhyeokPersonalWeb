package MH.domain.restaurant;

import MH.domain.restaurant.dto.PositionDto;
import MH.domain.restaurant.service.RestaurantService;
import MH.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantApiController {

	private final RestaurantService restaurantService;

	@GetMapping("api/restaurant")
	public ResponseEntity<?> getPosition() {
		List<PositionDto> positions = restaurantService.getPosition(restaurantService.getData());
		return new ResponseEntity<>(new CMRespDto<>(1, "성공", positions), HttpStatus.OK);
	}


}
