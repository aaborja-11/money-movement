package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.accounts.persistence.services.AccountDataService;
import com.aborja.moneymovement.application.dto.AccountDetails;
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
        final var account = accountDataService.findByUsername(username);
        validatePassword(password, account.getCredentials().getPassword());
        return AccountDetailsMapper.toAccountDetails(account);
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new InvalidCredentialsException();
        }
    }

}
