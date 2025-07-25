package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.command.CreateItemCommand;
import com.aborja.moneymovement.application.command.UpdateItemCommand;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.services.ItemCreationService;
import com.aborja.moneymovement.application.services.ItemFinderService;
import com.aborja.moneymovement.application.services.ItemModificationService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.CreateItemRequest;
import com.aborja.moneymovement.interfaces.web.v1.request.UpdateItemRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/assets/{assetId}/items")
public class ItemRestController {

    private final ItemCreationService itemCreationService;
    private final ItemFinderService itemFinderService;
    private final ItemModificationService itemModificationService;

    @PostMapping("")
    public ApiResponse<ItemDetails> create(@PathVariable UUID assetId,
                                           @Valid @RequestBody CreateItemRequest request) {
        final var command = request.toCreateItemCommand(assetId);
        final var itemDetails = itemCreationService.createItem(command);
        return ApiResponse.created(itemDetails);
    }

    @PatchMapping("/{itemId}")
    public ApiResponse<ItemDetails> create(@PathVariable UUID assetId,
                                           @PathVariable UUID itemId,
                                           @RequestBody UpdateItemRequest request) {
        final var command = request.toUpdateItemCommand(assetId, itemId);
        final var itemDetails = itemModificationService.updateItem(command);
        return ApiResponse.created(itemDetails);
    }

    @GetMapping("")
    public ApiResponse<ItemDetails> findAll(@PathVariable UUID assetId, Pageable pageable) {
        final var assetDetails = itemFinderService.findActiveItemByAssetId(assetId, pageable);
        return ApiResponse.success(assetDetails);
    }

}
