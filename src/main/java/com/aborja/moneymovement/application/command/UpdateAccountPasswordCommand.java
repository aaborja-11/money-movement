package com.aborja.moneymovement.application.command;

import java.util.UUID;

public record UpdateAccountPasswordCommand(UUID id, String password) {
}
