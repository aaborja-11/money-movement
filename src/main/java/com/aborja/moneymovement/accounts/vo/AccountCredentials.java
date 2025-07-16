package com.aborja.moneymovement.accounts.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Embeddable
public class AccountCredentials {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

}
