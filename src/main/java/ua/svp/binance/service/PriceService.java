package ua.svp.binance.service;

import ua.svp.binance.model.PriceEntity;
import ua.svp.binance.model.TickerEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<PriceEntity> getLastPrice(TickerEntity ticker);

    void clear(LocalDateTime time);

    PriceEntity savePrice(TickerEntity ticker, BigDecimal priceValue, LocalDateTime time);
}
