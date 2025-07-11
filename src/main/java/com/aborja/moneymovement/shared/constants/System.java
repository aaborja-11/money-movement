package com.aborja.moneymovement.shared.constants;

import lombok.Getter;

@Getter
public enum System {
    MONEY_MOVEMENT("mm");

    private final String value;

    System(String value) {
        this.value = value;
    }

}
