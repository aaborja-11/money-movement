package com.aborja.moneymovement.accounts.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Embeddable
public class AccountCredentials {

    private String username;
    private String password;

}
