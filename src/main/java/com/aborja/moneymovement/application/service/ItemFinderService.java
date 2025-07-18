package com.aborja.moneymovement.application.service;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.mapper.AssetDetailsMapper;
import com.aborja.moneymovement.application.mapper.ItemDetailsMapper;
import com.aborja.moneymovement.items.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemFinderService {

    private final ItemRepository itemRepository;

    public Page<ItemDetails> findActiveItemByAssetId(UUID id, Pageable pageable) {
        final var items = itemRepository.findActiveItemByAssetId(id, pageable);
        return ItemDetailsMapper.toItemDetails(items);
    }

}
