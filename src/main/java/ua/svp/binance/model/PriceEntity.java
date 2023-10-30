package ua.svp.binance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.svp.binance.model.id.PriceId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PriceId.class)
public class PriceEntity {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ticker_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ticker_key"))
    private TickerEntity ticker;

    @Id
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "value")
    private BigDecimal value;

}
