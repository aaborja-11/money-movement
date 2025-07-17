package com.aborja.moneymovement.application.mapper;

import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.items.entities.Item;

public final class ItemDetailsMapper {

    private ItemDetailsMapper() { }

    public static ItemDetails toItemDetails(Item item) {
        return new ItemDetails(
            item.getId(),
            item.getAssetId(),
            item.getName(),
            item.getUnitOfMeasurement(),
            item.getCostPrice(),
            item.getSellingPrice(),
            item.isActive(),
            item.getType()
        );
    }

}
