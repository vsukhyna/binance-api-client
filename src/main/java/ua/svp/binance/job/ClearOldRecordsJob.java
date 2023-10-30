package ua.svp.binance.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.svp.binance.service.PriceService;

import java.time.LocalDateTime;

@Component
@Slf4j
@AllArgsConstructor
@EnableScheduling
public class ClearOldRecordsJob {

    private final PriceService priceService;

    @Scheduled(fixedRate = 60000)
    private void clear() {
        priceService.clear(LocalDateTime.now().minusHours(24));
    }
}
