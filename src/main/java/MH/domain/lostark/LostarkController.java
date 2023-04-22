package MH.domain.lostark;

import MH.domain.lostark.dto.LostarkContentAvgDto;
import MH.domain.lostark.entity.lostarkMarketItems.LostarkMarketItem;
import MH.domain.lostark.service.LostarkContentAvgService;
import MH.domain.lostark.service.LostarkMarketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LostarkController {

	private final LostarkMarketItemService marketItemService;
	private final LostarkContentAvgService contentAvgService;

	@GetMapping("/lostark")
	public String index(Model model) {
		List<LostarkMarketItem> marketItems = marketItemService.getMarketItems();
		List<LostarkContentAvgDto> contentAvg = contentAvgService.contentAvg();
		List<LostarkContentAvgDto> contentAvgTotal = contentAvgService.contentAvgTotal(contentAvg);
		model.addAttribute("marketItems", marketItems);
		model.addAttribute("contentAvg", contentAvg);
		model.addAttribute("contentAvgTotal", contentAvgTotal);
		return "lostark/lostarkIndex";
	}
}
