package ua.svp.binance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ticker", uniqueConstraints = {
        @UniqueConstraint(name = "name_unique", columnNames = "name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "ticker", fetch = FetchType.LAZY)
    private List<PriceEntity> prices;

}
