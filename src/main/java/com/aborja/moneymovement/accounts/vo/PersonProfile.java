package com.aborja.moneymovement.accounts.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Embeddable
public class PersonProfile {

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

}
