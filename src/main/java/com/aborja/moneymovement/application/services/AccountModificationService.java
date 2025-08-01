package com.aborja.moneymovement.application.services;

import com.aborja.moneymovement.accounts.entities.Account;
import com.aborja.moneymovement.accounts.persistence.services.AccountDataService;
import com.aborja.moneymovement.application.command.UpdateAccountCommand;
import com.aborja.moneymovement.application.command.UpdateAccountPasswordCommand;
import com.aborja.moneymovement.application.dto.AccountDetails;
import com.aborja.moneymovement.application.mapper.AccountDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountModificationService {

    private final AccountDataService accountDataService;
    private final AuthenticationService authenticationService;

    public AccountDetails updateAccount(UpdateAccountCommand command) {
        final var account = accountDataService.findById(command.id());
        authenticationService.validatePassword(command.password(), account.getCredentials().getPassword());
        updatedAccountByCommand(account, command);
        final var updatedAccount = accountDataService.save(account);
        return AccountDetailsMapper.toAccountDetails(updatedAccount);
    }

    public AccountDetails updatePassword(UpdateAccountPasswordCommand command) {
        final var account = accountDataService.findById(command.id());
        final var encodedPassword = authenticationService.encodePassword(command.password());
        account.updatePassword(encodedPassword);

        final var updatedAccount = accountDataService.save(account);
        return AccountDetailsMapper.toAccountDetails(updatedAccount);
    }

    private void updatedAccountByCommand(Account account, UpdateAccountCommand command) {
        account.updateUsername(command.username());
        account.updatePersonProfile(command.firstname(), command.lastname());
        account.setUpdatedBy(account.getCredentials().getUsername());
    }

}
