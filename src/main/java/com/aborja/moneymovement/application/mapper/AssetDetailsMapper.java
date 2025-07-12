package com.aborja.moneymovement.application.mapper;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.assets.entities.Asset;

public final class AssetDetailsMapper {

    private AssetDetailsMapper() { }

    public static AssetDetails toAssetDetails(Asset asset) {
        return new AssetDetails(asset.getId(), asset.getName());
    }

}
