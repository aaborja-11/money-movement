package com.aborja.moneymovement.shared.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OperatingHours {
    private Instant openingTimestamp;
    private Instant closingTimestamp;
}
