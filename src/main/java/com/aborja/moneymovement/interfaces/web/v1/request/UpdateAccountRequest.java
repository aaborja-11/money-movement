package com.aborja.moneymovement.interfaces.web.v1.request;

import com.aborja.moneymovement.application.command.UpdateAccountCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAccountRequest {
    @NotBlank(message = "Firstname is required")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    private String lastname;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;

    public UpdateAccountCommand toUpdateAccountCommand(UUID accountId) {
        return new UpdateAccountCommand(
            accountId,
            firstname,
            lastname,
            username,
            password
        );
    }
}
