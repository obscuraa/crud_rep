package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.application.CreateApplicationDto;
import com.group.telegram_bot.dto.application.UpdateApplicationDto;
import com.group.telegram_bot.model.Application;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {
    List<Application> getApplications();

    Application findApplicationById(UUID applicationId);

    Application addNewApplication(CreateApplicationDto createApplicationDto);

    Boolean deleteApplication(UUID applicationId);

    Application updateApplication(UUID applicationId, UpdateApplicationDto updateApplicationDto);
}
