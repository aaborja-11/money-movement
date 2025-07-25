package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.application.command.CreateItemCommand;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.mapper.ItemDetailsMapper;
import com.aborja.moneymovement.assets.persistence.services.AssetDataService;
import com.aborja.moneymovement.items.entities.Item;
import com.aborja.moneymovement.items.persistence.ItemRepository;
import com.aborja.moneymovement.items.persistence.services.ItemDataService;
import com.aborja.moneymovement.items.valueobjects.ItemLabel;
import com.aborja.moneymovement.items.valueobjects.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCreationService {

    private final AssetDataService assetDataService;
    private final ItemDataService itemDataService;

    public ItemDetails createItem(CreateItemCommand command) {
        assetDataService.validateExistsOrThrow(command.assetId());
        final var item = command.toItem();
        final var savedItem = itemDataService.save(item);
        return ItemDetailsMapper.toItemDetails(savedItem);
    }

}
