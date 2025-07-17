package com.aborja.moneymovement.shared.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum System {
    MONEY_MOVEMENT("mm");

    private final String value;

}
