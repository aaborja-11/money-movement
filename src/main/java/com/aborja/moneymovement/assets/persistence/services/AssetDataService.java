package com.aborja.moneymovement.assets.persistence.services;

import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import com.aborja.moneymovement.assets.entities.Asset;
import com.aborja.moneymovement.assets.persistence.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetDataService {

    private final AssetRepository assetRepository;

    public Asset save(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset findById(UUID id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Asset.class, id));
    }

    public Page<Asset> findAll(Pageable pageable) {
        return assetRepository.findAll(pageable);
    }

    public boolean existsById(UUID id) {
        return assetRepository.existsById(id);
    }

    public void validateExistsOrThrow(UUID id) {
        if (!assetRepository.existsById(id)) {
            throw new ResourceNotFoundException(Asset.class, id);
        }
    }
}
