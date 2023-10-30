package ua.svp.binance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.svp.binance.model.PriceEntity;
import ua.svp.binance.model.TickerEntity;
import ua.svp.binance.model.id.PriceId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<PriceEntity, PriceId> {

    List<PriceEntity> findAllByTimeLessThan(LocalDateTime time);

    void deleteAllByTimeLessThan(LocalDateTime time);

    Optional<PriceEntity> findFirstByTickerOrderByTimeDesc(TickerEntity ticker);
}
