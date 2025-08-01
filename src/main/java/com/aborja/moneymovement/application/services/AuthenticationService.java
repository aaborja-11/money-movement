package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.accounts.entities.Account;
import com.aborja.moneymovement.accounts.persistence.services.AccountDataService;
import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.exception.AccountNotFoundException;
import com.aborja.moneymovement.application.exception.InvalidCredentialsException;
import com.aborja.moneymovement.application.mapper.AccountDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountDataService accountDataService;
    private final PasswordEncoder passwordEncoder;

    public AccountDetails authenticate(String username, String password) {
        final var account = findByUsernameElseThrow(username);
        validatePassword(password, account.getCredentials().getPassword());
        return AccountDetailsMapper.toAccountDetails(account);
    }

    public void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new InvalidCredentialsException();
        }
    }

    public Account findByUsernameElseThrow(String username) {
        try {
            return accountDataService.findByUsername(username);
        } catch(AccountNotFoundException e) {
            throw new InvalidCredentialsException();
        }
    }

}
