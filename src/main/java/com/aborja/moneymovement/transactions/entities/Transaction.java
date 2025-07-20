package com.aborja.moneymovement.transactions.entities;

import com.aborja.moneymovement.shared.constants.TransactionType;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
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

    @Column(nullable = false)
    private BigDecimal transactionAmount = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal transactionQuantity = BigDecimal.ZERO;

    @Column(nullable = false, length = 75)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    private Instant transactionTimestamp;

}
