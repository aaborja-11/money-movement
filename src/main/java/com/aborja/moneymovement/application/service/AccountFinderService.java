package com.aborja.moneymovement.application.service;

import com.aborja.moneymovement.accounts.entities.Account;
import com.aborja.moneymovement.accounts.persistence.AccountRepository;
import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import com.aborja.moneymovement.application.mapper.AccountDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountFinderService {

    private final AccountRepository accountRepository;

    public AccountDetails findById(UUID id) {
        final var account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Account.class, id));
        return AccountDetailsMapper.toAccountDetails(account);
    }

}
