package MH.domain.lostark.service;

import MH.domain.lostark.dto.LostarkMarketItemDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LostarkScheduledService {

    private final LostarkMarketApiService lostarkMarketApiService;
    private final LostarkMarketItemService lostarkMarketItemService;

    // 6시간 간격으로 거래소 데이터 가져오기 실행
    // 재련재료 데이터 (50000)
    @Scheduled(cron = "0 0 */6 * * *")
    public void getMarket50000() {
        JSONArray result = lostarkMarketApiService.getMarketCategories(50000);
        result.forEach((data) -> {
            LostarkMarketItemDto lostarkMarketItemDto = new LostarkMarketItemDto((JSONObject) data);
            lostarkMarketItemService.save(lostarkMarketItemDto);
        });
    }
}
