package com.aborja.moneymovement.accounts.entities;

import com.aborja.moneymovement.accounts.vo.AccountCredentials;
import com.aborja.moneymovement.accounts.vo.PersonProfile;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private PersonProfile profile;

    @Embedded
    private AccountCredentials credentials;

}
