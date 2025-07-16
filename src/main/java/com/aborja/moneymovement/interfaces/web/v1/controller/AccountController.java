package com.aborja.moneymovement.interfaces.web.v1.controller;

import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.dto.AssetDetails;
import com.aborja.moneymovement.application.service.AccountFinderService;
import com.aborja.moneymovement.interfaces.web.shared.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountFinderService accountFinderService;

    @GetMapping("/{accountId}")
    public ApiResponse<AccountDetails> findById(@PathVariable UUID accountId) {
        final var accountDetails = accountFinderService.findById(accountId);
        return ApiResponse.success(accountDetails);
    }

}
