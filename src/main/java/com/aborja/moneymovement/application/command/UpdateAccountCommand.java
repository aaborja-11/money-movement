package com.aborja.moneymovement.application.command;

import java.util.UUID;

public record UpdateAccountCommand(UUID id, String firstname, String lastname, String username, String password) {
}
