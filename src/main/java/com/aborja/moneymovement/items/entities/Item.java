package com.aborja.moneymovement.items.entities;

import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Item extends BaseEntity {

    @Column(nullable = false)
    private UUID assetId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    @Column(nullable = false)
    private BigDecimal costPrice = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal sellingPrice = BigDecimal.ZERO;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ItemType type;

}
