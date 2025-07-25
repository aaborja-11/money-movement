package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.application.command.UpdateItemCommand;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.mapper.ItemDetailsMapper;
import com.aborja.moneymovement.assets.persistence.services.AssetDataService;
import com.aborja.moneymovement.items.entities.Item;
import com.aborja.moneymovement.items.persistence.services.ItemDataService;
import com.aborja.moneymovement.items.valueobjects.ItemLabel;
import com.aborja.moneymovement.items.valueobjects.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemModificationService {

    private final AssetDataService assetDataService;
    private final ItemDataService itemDataService;

    public ItemDetails updateItem(UpdateItemCommand command) {
        assetDataService.validateExistsOrThrow(command.assetId());
        final var item = itemDataService.findById(command.id());
        updateItemByCommand(item, command);
        final var savedItem = itemDataService.save(item);
        return ItemDetailsMapper.toItemDetails(savedItem);
    }

    private void updateItemByCommand(final Item item, UpdateItemCommand command) {
        final var itemLabel = item.getItemLabel();
        final var active = Optional.ofNullable(command.active()).orElse(itemLabel.isActive());
        final var name = Optional.ofNullable(command.name()).orElse(itemLabel.getName());

        item.setItemLabel(new ItemLabel(name, active));
        item.setType(Optional.ofNullable(command.type()).orElse(item.getType()));
        item.setCostPrice(new Price(Optional.ofNullable(command.costPrice()).orElse(item.getCostPrice().getAmount())));
        item.setSellingPrice(new Price(Optional.ofNullable(command.sellingPrice()).orElse(item.getSellingPrice().getAmount())));
        item.setUnitOfMeasurement(Optional.ofNullable(command.unitOfMeasurement()).orElse(item.getUnitOfMeasurement()));
    }
}
