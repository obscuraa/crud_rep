package com.group.telegram_bot.model.projection;

public interface CircleActivityProjection {
    String getSupervisorName();

    String getCircleName();

    String getMembers();

    void setSupervisorName(String supervisorName);

    void setCircleName(String circleName);

    void setMembers(String members);
}
