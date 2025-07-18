package com.aborja.moneymovement.application.command;

import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateItemCommand(
    UUID id,
    UUID assetId,
    String name,
    UnitOfMeasurement unitOfMeasurement,
    BigDecimal costPrice,
    BigDecimal sellingPrice,
    Boolean active,
    ItemType type) {
}
