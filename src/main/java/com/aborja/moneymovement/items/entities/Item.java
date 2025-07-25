package com.aborja.moneymovement.items.entities;

import com.aborja.moneymovement.items.valueobjects.ItemLabel;
import com.aborja.moneymovement.items.valueobjects.Price;
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

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(nullable = false, name = "name")),
        @AttributeOverride(name = "active", column = @Column(nullable = false, name = "active"))
    })
    private ItemLabel itemLabel;

    @Column(nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "cost_price"))
    })
    private Price costPrice = new Price(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "selling_price"))
    })
    private Price sellingPrice = new Price(BigDecimal.ZERO);

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ItemType type;

}
