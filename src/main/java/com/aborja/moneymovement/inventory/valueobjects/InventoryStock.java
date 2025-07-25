package com.aborja.moneymovement.inventory.valueobjects;

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
public class InventoryStock {
    private BigDecimal count;
}
