package com.aborja.moneymovement.sales.entities;

import com.aborja.moneymovement.sales.valueobjects.Expense;
import com.aborja.moneymovement.sales.valueobjects.Income;
import com.aborja.moneymovement.sales.valueobjects.Loss;
import com.aborja.moneymovement.sales.valueobjects.Profit;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import com.aborja.moneymovement.shared.valueobjects.OperatingHours;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Sales extends BaseEntity {

    @Column(nullable = false)
    private UUID itemId;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "income"))
    })
    private Income income = new Income(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "profit"))
    })
    private Profit profit = new Profit(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "expense"))
    })
    private Expense expense = new Expense(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "loss"))
    })
    private Loss loss = new Loss(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "openingTimestamp", column = @Column(name = "opening_timestamp")),
        @AttributeOverride(name = "closingTimestamp", column = @Column(name = "closing_timestamp"))
    })
    private OperatingHours operatingHours;

}
