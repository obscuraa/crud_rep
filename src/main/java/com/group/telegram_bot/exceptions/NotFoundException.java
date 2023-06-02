package com.group.telegram_bot.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Object id) {
        super(String.format(message, id));
    }
}
