package com.aborja.moneymovement.interfaces.web.v1.request;

import com.aborja.moneymovement.shared.constants.ItemType;
import com.aborja.moneymovement.shared.constants.UnitOfMeasurement;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateItemRequest {
    private String name;
    private UnitOfMeasurement unitOfMeasurement;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private Boolean active;
    private ItemType type;
}
