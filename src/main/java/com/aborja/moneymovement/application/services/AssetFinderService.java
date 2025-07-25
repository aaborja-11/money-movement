package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.mapper.AssetDetailsMapper;
import com.aborja.moneymovement.assets.persistence.services.AssetDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetFinderService {

    private final AssetDataService assetDataService;

    public AssetDetails findById(UUID id) {
        final var asset = assetDataService.findById(id);
        return AssetDetailsMapper.toAssetDetails(asset);
    }

    public Page<AssetDetails> findAll(Pageable pageable) {
        final var assets = assetDataService.findAll(pageable);
        return AssetDetailsMapper.toAssetDetails(assets);
    }

}
