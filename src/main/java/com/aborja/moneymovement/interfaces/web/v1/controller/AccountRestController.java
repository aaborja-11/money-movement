package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.services.AccountFinderService;
import com.aborja.moneymovement.application.services.AuthenticationService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import com.aborja.moneymovement.interfaces.web.v1.request.AccountLoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountFinderService accountFinderService;
    private final AuthenticationService authenticationService;

    @GetMapping("/{accountId}")
    public ApiResponse<AccountDetails> findById(@PathVariable UUID accountId) {
        final var accountDetails = accountFinderService.findById(accountId);
        return ApiResponse.success(accountDetails);
    }

    @PostMapping("/sessions")
    public ApiResponse<AccountDetails> login(@Valid @RequestBody AccountLoginRequest request) {
        final var accountDetails = authenticationService.authenticate(request.getUsername(), request.getPassword());
        return ApiResponse.success(accountDetails);
    }

}
