package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.accounts.persistence.services.AccountDataService;
import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.mapper.AccountDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountFinderService {

    private final AccountDataService accountDataService;

    public AccountDetails findById(UUID id) {
        final var account = accountDataService.findById(id);
        return AccountDetailsMapper.toAccountDetails(account);
    }

}
