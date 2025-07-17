package com.aborja.moneymovement.interfaces.web.v1.request;

import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CreateItemRequest {

    @NotNull(message = "assetId is required")
    private UUID assetId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "unitOfMeasurement is required")
    private UnitOfMeasurement unitOfMeasurement;

    @NotNull(message = "costPrice is required")
    @DecimalMin(value = "0.00", message = "costPrice must be greater than or equal 0")
    private BigDecimal costPrice;

    @NotNull(message = "sellingPrice is required")
    @DecimalMin(value = "0.00", message = "sellingPrice must be greater than or equal 0")
    private BigDecimal sellingPrice;

    private boolean active;

    @NotNull(message = "type is required")
    private ItemType type;
}
