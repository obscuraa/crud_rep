package com.group.telegram_bot.dto.student;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StudentRole {
    STUDENT("Студент"),
    PLATOON_COMMANDER("Руководитель взвода"),
    GROUP_COMMANDER("Руководитель группы"),
    CLUB_COMMANDER("Руководитель клуба");

    private final String textValue;

    StudentRole(String textValue) {
        this.textValue = textValue;
    }

    @JsonValue
    public String getTextValue() {
        return textValue;
    }
}
