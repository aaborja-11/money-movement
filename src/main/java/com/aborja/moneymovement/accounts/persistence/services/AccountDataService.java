package com.aborja.moneymovement.accounts.persistence.services;

import com.aborja.moneymovement.accounts.entities.Account;
import com.aborja.moneymovement.accounts.persistence.AccountRepository;
import com.aborja.moneymovement.application.exception.InvalidCredentialsException;
import com.aborja.moneymovement.application.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountDataService {
    private final AccountRepository accountRepository;

    public Account findById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Account.class, id));
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(InvalidCredentialsException::new);
    }
}
