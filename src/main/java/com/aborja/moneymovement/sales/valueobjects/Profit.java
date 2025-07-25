package com.aborja.moneymovement.sales.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Profit {
    private BigDecimal amount;
}
