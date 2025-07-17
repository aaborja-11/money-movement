package com.aborja.moneymovement.application.dto;


import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDetails(UUID id, UUID assetId, String name, UnitOfMeasurement unitOfMeasurement, BigDecimal costPrice, BigDecimal sellingPrice, boolean active, ItemType type) {
}
