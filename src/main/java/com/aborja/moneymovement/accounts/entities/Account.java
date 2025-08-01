package com.aborja.moneymovement.accounts.entities;

import com.aborja.moneymovement.accounts.valueobjects.AccountCredentials;
import com.aborja.moneymovement.accounts.valueobjects.PersonProfile;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Account extends BaseEntity {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "firstname", column = @Column(nullable = false, name = "firstname")),
        @AttributeOverride(name = "lastname", column = @Column(nullable = false, name = "lastname"))
    })
    private PersonProfile profile;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "username", column = @Column(nullable = false, unique = true, name = "username")),
        @AttributeOverride(name = "password", column = @Column(nullable = false, columnDefinition = "TEXT", name = "password"))
    })
    private AccountCredentials credentials;

    public void updatePersonProfile(String firstname,
                                    String lastname) {
        this.profile = new PersonProfile(firstname, lastname);
    }

    public void updateUsername(String username) {
        this.credentials = new AccountCredentials(
            username,
            this.credentials.getPassword()
        );
    }

    public void updatePassword(String password) {
        this.credentials = new AccountCredentials(
            this.credentials.getUsername(),
            password
        );
    }

}
