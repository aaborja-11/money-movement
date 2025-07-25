package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.services.AssetCreationService;
import com.aborja.moneymovement.application.services.AssetFinderService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.CreateAssetRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/assets")
public class AssetRestController {

    private final AssetCreationService assetCreationService;
    private final AssetFinderService assetFinderService;

    @PostMapping("")
    public ApiResponse<AssetDetails> create(@Valid @RequestBody CreateAssetRequest request) {
        final var assetDetails = assetCreationService.createAsset(request.getName());
        return ApiResponse.created(assetDetails);
    }

    @GetMapping("/{assetId}")
    public ApiResponse<AssetDetails> find(@PathVariable UUID assetId) {
        final var assetDetails = assetFinderService.findById(assetId);
        return ApiResponse.success(assetDetails);
    }

    @GetMapping("")
    public ApiResponse<AssetDetails> findAll(Pageable pageable) {
        final var assetDetails = assetFinderService.findAll(pageable);
        return ApiResponse.success(assetDetails);
    }

}
