package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.command.UpdateAccountPasswordCommand;
import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.services.AccountFinderService;
import com.aborja.moneymovement.application.services.AccountModificationService;
import com.aborja.moneymovement.application.services.AuthenticationService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.LoginAccountRequest;
import com.aborja.moneymovement.interfaces.web.v1.request.UpdateAccountRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountFinderService accountFinderService;
    private final AccountModificationService accountModificationService;
    private final AuthenticationService authenticationService;

    @GetMapping("/{accountId}")
    public ApiResponse<AccountDetails> findById(@PathVariable UUID accountId) {
        final var accountDetails = accountFinderService.findById(accountId);
        return ApiResponse.success(accountDetails);
    }

    @PutMapping("/{accountId}")
    public ApiResponse<AccountDetails> updateAccount(@PathVariable UUID accountId,
                                                     @Valid @RequestBody UpdateAccountRequest request) {
        final var command = request.toUpdateAccountCommand(accountId);
        final var accountDetails = accountModificationService.updateAccount(command);
        return ApiResponse.success(accountDetails);
    }

    @PatchMapping(value = "/{accountId}", params = {"password"})
    public ApiResponse<AccountDetails> updateAccountPassword(@PathVariable UUID accountId,
                                                             @RequestParam String password) {
        final var command = new UpdateAccountPasswordCommand(accountId, password);
        final var accountDetails = accountModificationService.updatePassword(command);
        return ApiResponse.success(accountDetails);
    }

    @PostMapping("/sessions")
    public ApiResponse<AccountDetails> login(@Valid @RequestBody LoginAccountRequest request) {
        final var accountDetails = authenticationService.authenticate(request.getUsername(), request.getPassword());
        return ApiResponse.success(accountDetails);
    }

}
