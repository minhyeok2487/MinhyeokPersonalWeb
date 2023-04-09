package MH.domain.lostark;

import MH.domain.lostark.dto.LostarkMarketItemDto;
import MH.domain.lostark.service.LostarkMarketItemService;
import MH.domain.lostark.service.LostarkMarketApiService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LostarkApiController {

	private final LostarkMarketApiService lostarkMarketApiService;
	private final LostarkMarketItemService lostarkMarketItemService;


	@GetMapping("/lostark/api/saveMarketData/{categoryCode}")
	public JSONArray saveMarketData(@PathVariable int categoryCode) {
		JSONArray result = lostarkMarketApiService.getMarketCategories(categoryCode);
		result.forEach((data) -> {
			LostarkMarketItemDto lostarkMarketItemDto = new LostarkMarketItemDto((JSONObject) data);
			lostarkMarketItemService.save(lostarkMarketItemDto);
		});
		return result;
	}
}
