package com.aborja.moneymovement.application.dto;

import java.util.UUID;

public record AccountDetails(UUID id, String firstname, String lastname, String username) {
}
