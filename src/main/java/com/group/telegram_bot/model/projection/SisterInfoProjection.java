package com.group.telegram_bot.model.projection;

public interface SisterInfoProjection {
    String getName();

    String getTelephoneNumber();

    String getAddress();

    String getJobAddress();

    void setName(String name);

    void setTelephoneNumber(String telephoneNumber);

    void setAddress(String address);

    void setJobAddress(String jobAddress);
}
