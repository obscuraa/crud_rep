package com.group.telegram_bot.exceptions;

public class NotFoundDbObject extends RuntimeException {
    public NotFoundDbObject(String message) {
        super(message);
    }
}
