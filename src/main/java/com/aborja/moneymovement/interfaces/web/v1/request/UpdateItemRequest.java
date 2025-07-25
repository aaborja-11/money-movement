package com.aborja.moneymovement.interfaces.web.v1.request;

import com.aborja.moneymovement.application.command.UpdateItemCommand;
import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UpdateItemRequest {
    private String name;
    private UnitOfMeasurement unitOfMeasurement;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private Boolean active;
    private ItemType type;

    public UpdateItemCommand toUpdateItemCommand(UUID itemId, UUID assetId) {
        return new UpdateItemCommand(
            itemId,
            assetId,
            name,
            unitOfMeasurement,
            costPrice,
            sellingPrice,
            active,
            type
        );
    }
}
