package com.aborja.moneymovement.application.mapper;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.assets.entities.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public final class AssetDetailsMapper {

    private AssetDetailsMapper() { }

    public static AssetDetails toAssetDetails(Asset asset) {
        return new AssetDetails(asset.getId(), asset.getName());
    }

    public static Page<AssetDetails> toAssetDetails(Page<Asset> assets) {
        return assets.map(AssetDetailsMapper::toAssetDetails);
    }

}
