package ua.svp.binance.model.id;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
@Setter
@EqualsAndHashCode
@ToString
public class PriceId implements Serializable {
    private UUID ticker;
    private LocalDateTime time;
}
