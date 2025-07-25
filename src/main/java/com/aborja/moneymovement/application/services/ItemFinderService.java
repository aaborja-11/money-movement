package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.mapper.ItemDetailsMapper;
import com.aborja.moneymovement.items.persistence.ItemRepository;
import com.aborja.moneymovement.items.persistence.services.ItemDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemFinderService {

    private final ItemDataService itemDataService;

    public Page<ItemDetails> findActiveItemByAssetId(UUID id, Pageable pageable) {
        final var items = itemDataService.findActiveItemByAssetId(id, pageable);
        return ItemDetailsMapper.toItemDetails(items);
    }

}
