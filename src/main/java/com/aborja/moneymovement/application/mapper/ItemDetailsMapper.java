package com.aborja.moneymovement.application.mapper;

import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.items.entities.Item;
import org.springframework.data.domain.Page;

public final class ItemDetailsMapper {

    private ItemDetailsMapper() { }

    public static ItemDetails toItemDetails(Item item) {
        final var itemLabel = item.getItemLabel();

        return new ItemDetails(
            item.getId(),
            item.getAssetId(),
            itemLabel.getName(),
            item.getUnitOfMeasurement(),
            item.getCostPrice().getAmount(),
            item.getSellingPrice().getAmount(),
            itemLabel.isActive(),
            item.getType()
        );
    }

    public static Page<ItemDetails> toItemDetails(Page<Item> items) {
        return items.map(ItemDetailsMapper::toItemDetails);
    }

}
