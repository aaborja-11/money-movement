package com.aborja.moneymovement.items.persistence.services;

import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import com.aborja.moneymovement.items.entities.Item;
import com.aborja.moneymovement.items.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemDataService {

    private final ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item findById(UUID id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Item.class, id));
    }

    public Page<Item> findActiveItemByAssetId(UUID assetId, Pageable pageable){
        return itemRepository.findActiveItemByAssetId(assetId, pageable);
    }
}
