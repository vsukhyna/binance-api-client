package ua.svp.binance.service;

import ua.svp.binance.model.TickerEntity;

public interface TickerService {

    TickerEntity saveTicker(String tickerName);

    TickerEntity findTickerByName(String tickerName);

}
