package com.aborja.moneymovement.application.command;

import com.aborja.moneymovement.items.entities.Item;
import com.aborja.moneymovement.items.valueobjects.ItemLabel;
import com.aborja.moneymovement.items.valueobjects.Price;
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

    public Item toItem() {
        return Item.builder()
            .assetId(assetId)
            .itemLabel(new ItemLabel(name, active))
            .costPrice(new Price(costPrice))
            .sellingPrice(new Price(sellingPrice))
            .unitOfMeasurement(unitOfMeasurement)
            .type(type)
            .build();
    }
}
