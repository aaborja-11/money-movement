package com.aborja.moneymovement.application.mapper;

import com.aborja.moneymovement.accounts.entities.Account;
import com.aborja.moneymovement.application.dto.AccountDetails;

public final class AccountDetailsMapper {

    public static AccountDetails toAccountDetails(Account account) {
        final var profile = account.getProfile();
        final var credentials = account.getCredentials();
        return new AccountDetails(
            account.getId(),
            profile.getFirstname(),
            profile.getLastname(),
            credentials.getUsername()
        );
    }

}
