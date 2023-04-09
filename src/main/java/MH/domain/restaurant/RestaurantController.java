package MH.domain.restaurant;

import MH.domain.restaurant.entity.Restaurant;
import MH.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
	private final RestaurantService restaurantService;

	@GetMapping("/restaurant")
	public String index(Model model) {
		List<Restaurant> data = restaurantService.getData();
		//List<Restaurant> allData = restaurantService.getAllData();
		//List<PositionDto> positions = restaurantService.getPosition(data);
		//System.out.println(data.get(0));
		model.addAttribute("data", data);
		//model.addAttribute("allData", allData);
		//model.addAttribute("positions", positions);
		return "restaurant/restaurantIndex";
	}
}
