package com.aborja.moneymovement.transactions.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TransactionTimestamp {
    private Instant dateTime;
}
