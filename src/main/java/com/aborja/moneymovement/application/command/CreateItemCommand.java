package com.aborja.moneymovement.application.command;

import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateItemCommand(
        UUID assetId,
        String name,
        UnitOfMeasurement unitOfMeasurement,
        BigDecimal costPrice,
        BigDecimal sellingPrice,
        boolean active,
        ItemType type) {
}
