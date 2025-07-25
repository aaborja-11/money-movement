package com.aborja.moneymovement.inventory.entities;

import com.aborja.moneymovement.inventory.valueobjects.InventoryStock;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import com.aborja.moneymovement.shared.valueobjects.OperatingHours;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Inventory extends BaseEntity {

    @Column(nullable = false)
    private UUID itemId;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "count", column = @Column(nullable = false, name = "opening_stock"))
    })
    private InventoryStock openingStock = new InventoryStock(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "count", column = @Column(nullable = false, name = "remaining_stock"))
    })
    private InventoryStock remainingStock = new InventoryStock(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "openingTimestamp", column = @Column(name = "opening_timestamp")),
        @AttributeOverride(name = "closingTimestamp", column = @Column(name = "closing_timestamp"))
    })
    private OperatingHours operatingHours;

}
