package com.aborja.moneymovement.application.service;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.mapper.AssetDetailsMapper;
import com.aborja.moneymovement.assets.entities.Asset;
import com.aborja.moneymovement.assets.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetCreationService {

    private final AssetRepository assetRepository;

    public AssetDetails createAsset(String name) {
        final var asset = Asset.builder()
            .name(name)
            .build();
        return AssetDetailsMapper.toAssetDetails(assetRepository.save(asset));
    }
}
