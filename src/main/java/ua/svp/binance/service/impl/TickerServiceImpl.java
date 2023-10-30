package ua.svp.binance.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.svp.binance.model.TickerEntity;
import ua.svp.binance.repository.TickerRepository;
import ua.svp.binance.service.TickerService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TickerServiceImpl implements TickerService {

    private final TickerRepository tickerRepository;

    public TickerEntity saveTicker(String tickerName) {
        TickerEntity tickerEntity = new TickerEntity();
        tickerEntity.setName(tickerName);
        return tickerRepository.save(tickerEntity);
    }

    public TickerEntity findTickerByName(String tickerName) {
        Optional<TickerEntity> ticker = tickerRepository.getByName(tickerName);
        return ticker.orElseGet(() -> saveTicker(tickerName));
    }
}
