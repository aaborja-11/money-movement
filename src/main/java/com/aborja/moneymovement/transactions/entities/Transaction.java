package com.aborja.moneymovement.transactions.entities;

import com.aborja.moneymovement.shared.constants.TransactionType;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import com.aborja.moneymovement.transactions.valueobjects.Payment;
import com.aborja.moneymovement.transactions.valueobjects.SoldQuantity;
import com.aborja.moneymovement.transactions.valueobjects.TransactionTimestamp;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Transaction extends BaseEntity {

    @Column(nullable = false)
    private UUID itemId;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(nullable = false, name = "payment"))
    })
    private Payment payment = new Payment(BigDecimal.ZERO);

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "count", column = @Column(nullable = false, name = "quantity"))
    })
    private SoldQuantity quantity = new SoldQuantity(BigDecimal.ZERO);

    @Column(nullable = false, length = 75)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "dateTime", column = @Column(nullable = false, name = "transaction_timestamp"))
    })
    private TransactionTimestamp transactionTimestamp;

}
