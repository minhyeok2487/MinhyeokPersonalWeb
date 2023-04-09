package MH.domain.lostark;

import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItem;
import MH.domain.lostark.service.LostarkMarketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LostarkController {

	private final LostarkMarketItemService lostarkMarketItemService;

	@GetMapping("/lostark")
	public String index(Model model) {
		List<LostarkMarketItem> marketItems = lostarkMarketItemService.getMarketItems();
		model.addAttribute("marketItems", marketItems);
		return "lostark/lostarkIndex";
	}
}
