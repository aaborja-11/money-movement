package com.aborja.moneymovement.inventory.entities;

import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(nullable = false)
    private BigDecimal openingStock = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal remainingStock = BigDecimal.ZERO;

    @Column
    private Instant openingTimestamp;

    @Column
    private Instant closingTimestamp;

}
