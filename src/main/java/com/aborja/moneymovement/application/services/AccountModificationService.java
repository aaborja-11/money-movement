package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.accounts.persistence.services.AccountDataService;
import com.aborja.moneymovement.application.command.AccountUpdateCommand;
import com.aborja.moneymovement.application.dto.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountModificationService {

    private final AccountDataService accountDataService;

    public AccountDetails updateAccount(AccountUpdateCommand command) {

    }

}
