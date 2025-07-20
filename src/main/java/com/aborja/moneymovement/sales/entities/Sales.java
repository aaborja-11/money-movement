package com.aborja.moneymovement.sales.entities;

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
@Table(name = "sales")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Sales extends BaseEntity {

    @Column(nullable = false)
    private UUID itemId;

    @Column(nullable = false)
    private BigDecimal income = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal profit = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal expense = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal loss = BigDecimal.ZERO;

    @Column
    private Instant openingTimestamp;

    @Column
    private Instant closingTimestamp;

}
