package com.aborja.moneymovement.application.service;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.exception.AssetNotFoundException;
import com.aborja.moneymovement.application.mapper.AssetDetailsMapper;
import com.aborja.moneymovement.assets.repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetQueryService {

    private final AssetRepository assetRepository;

    public AssetDetails findById(UUID id) {
        final var asset = assetRepository.findById(id)
                .orElseThrow(AssetNotFoundException::new);
        return AssetDetailsMapper.toAssetDetails(asset);
    }

}
