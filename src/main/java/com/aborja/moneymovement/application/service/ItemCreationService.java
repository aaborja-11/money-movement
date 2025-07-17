package com.aborja.moneymovement.application.service;

import com.aborja.moneymovement.application.command.CreateItemCommand;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.mapper.ItemDetailsMapper;
import com.aborja.moneymovement.items.entities.Item;
import com.aborja.moneymovement.items.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCreationService {

    private final AssetFinderService assetFinderService;
    private final ItemRepository itemRepository;

    public ItemDetails createItem(CreateItemCommand command) {
        assetFinderService.existsOrElseThrow(command.assetId());

        final var item = Item.builder()
            .assetId(command.assetId())
            .name(command.name())
            .costPrice(command.costPrice())
            .sellingPrice(command.sellingPrice())
            .active(command.active())
            .unitOfMeasurement(command.unitOfMeasurement())
            .type(command.type())
            .build();

        final var savedItem = itemRepository.save(item);

        return ItemDetailsMapper.toItemDetails(savedItem);
    }

}
