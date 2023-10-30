package ua.svp.binance.config;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.svp.binance.provider.SettingsProvider;

@Configuration
@AllArgsConstructor
public class BinanceRestConfig {

    private final SettingsProvider provider;

    @Bean
    public BinanceApiRestClient binanceApiRestClient() {
        return BinanceApiClientFactory.newInstance(provider.getApiKey(),
                provider.getSecretKey()).newRestClient();
    }
}
