package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.command.CreateItemCommand;
import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.dto.ItemDetails;
import com.aborja.moneymovement.application.service.ItemCreationService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.CreateAssetRequest;
import com.aborja.moneymovement.interfaces.web.v1.request.CreateItemRequest;
import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/items")
public class ItemRestController {

    private final ItemCreationService itemCreationService;

    @PostMapping("")
    public ApiResponse<ItemDetails> create(@Valid @RequestBody CreateItemRequest request) {
        final var command = new CreateItemCommand(
            request.getAssetId(),
            request.getName(),
            request.getUnitOfMeasurement(),
            request.getCostPrice(),
            request.getSellingPrice(),
            request.isActive(),
            request.getType()
        );
        final var itemDetails = itemCreationService.createItem(command);
        return ApiResponse.created(itemDetails);
    }

}
