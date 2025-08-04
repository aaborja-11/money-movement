package com.aborja.moneymovement.interfaces.web.v1.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginAccountRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
}
