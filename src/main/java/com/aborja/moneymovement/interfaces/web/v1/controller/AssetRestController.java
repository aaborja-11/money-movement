package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.service.AssetCreationService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.CreateAssetRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/assets")
public class AssetRestController {

    private final AssetCreationService assetCreationService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<AssetDetails> create(@Valid @RequestBody CreateAssetRequest request) {
        final var assetDetails = assetCreationService.createAsset(request.getName());
        return ApiResponse.create(assetDetails);
    }

}
