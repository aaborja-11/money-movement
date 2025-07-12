package com.aborja.moneymovement.interfaces.web.v1.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAssetRequest

{
    @NotBlank(message = "Name is required")
    private String name;
}
