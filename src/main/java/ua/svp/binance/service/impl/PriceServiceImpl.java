package ua.svp.binance.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.svp.binance.model.PriceEntity;
import ua.svp.binance.model.TickerEntity;
import ua.svp.binance.repository.PriceRepository;
import ua.svp.binance.service.PriceService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public Optional<PriceEntity> getLastPrice(TickerEntity ticker) {
        return priceRepository.findFirstByTickerOrderByTimeDesc(ticker);
    }

    public void clear(LocalDateTime time) {
        priceRepository.deleteAllByTimeLessThan(time);
    }

    public PriceEntity savePrice(TickerEntity ticker, BigDecimal priceValue, LocalDateTime time) {
        PriceEntity priceEntity = new PriceEntity(ticker, time, priceValue);
        return priceRepository.save(priceEntity);
    }
}
