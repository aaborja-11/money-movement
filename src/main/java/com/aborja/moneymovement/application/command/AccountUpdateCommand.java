package com.aborja.moneymovement.application.command;

import java.util.UUID;

public record AccountUpdateCommand(UUID id, String firstname, String lastname, String username, String password, String confirmPassword) {
}
