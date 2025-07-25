package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.mapper.AssetDetailsMapper;
import com.aborja.moneymovement.assets.entities.Asset;
import com.aborja.moneymovement.assets.persistence.services.AssetDataService;
import com.aborja.moneymovement.assets.valueobjects.AssetLabel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetCreationService {

    private final AssetDataService assetDataService;

    public AssetDetails createAsset(String name) {
        final var asset = Asset.builder()
            .assetLabel(new AssetLabel(name))
            .build();
        return AssetDetailsMapper.toAssetDetails(assetDataService.save(asset));
    }
}
