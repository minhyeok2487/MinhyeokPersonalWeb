package MH.domain.lostark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LostarkScheduledService {

    private final LostarkMarketApiService lostarkMarketApiService;

    // 매일 자정에 거래소 데이터 가져오기 실행
    // 재련재료 데이터 (50000)
    @Scheduled(cron = "0 0 0 * * *")
    public void getMarket50000() {
        lostarkMarketApiService.getMarketCategories(50000);
    }
}
