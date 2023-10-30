package ua.svp.binance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.svp.binance.model.TickerEntity;

import java.util.Optional;
import java.util.UUID;

public interface TickerRepository extends JpaRepository<TickerEntity, UUID> {

    Optional<TickerEntity> getByName(String name);
}
