package ua.svp.binance.job;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.svp.binance.model.TickerEntity;
import ua.svp.binance.service.PriceService;
import ua.svp.binance.service.TickerService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class BinanceFetcherJob {

    private final TickerService tickerService;
    private final PriceService priceService;
    private final BinanceApiRestClient binanceApiRestClient;

    @Scheduled(fixedRate = 60000)
    private void call() {

        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();

        tickerPrices.forEach(tickerPrice -> {

            try {

                String tickerName = tickerPrice.getSymbol();
                TickerEntity tickerEntity = tickerService.findTickerByName(tickerName);
                BigDecimal price = new BigDecimal(tickerPrice.getPrice());

                priceService.savePrice(tickerEntity, price, LocalDateTime.now());

            } catch (Exception e) {
                log.error("Ticker: {}, Price: {}, Exception: {}", tickerPrice.getSymbol(), tickerPrice.getPrice(), e);
            }

        });
    }
}