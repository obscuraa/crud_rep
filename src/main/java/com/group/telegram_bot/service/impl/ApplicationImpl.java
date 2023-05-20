package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.ApplicationRepository;
import com.group.telegram_bot.dto.application.CreateApplicationDto;
import com.group.telegram_bot.dto.application.UpdateApplicationDto;
import com.group.telegram_bot.mapper.ApplicationMapper;
import com.group.telegram_bot.model.Application;
import com.group.telegram_bot.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findApplicationById(UUID applicationId) {
        return applicationRepository.findById(applicationId).orElse(null);
    }

    @Override
    public Application addNewApplication(CreateApplicationDto createApplicationDto) {
        Application application = applicationMapper.createDtoToEntity(createApplicationDto);

        var result = applicationRepository.save(application);
        return result;
    }

    @Override
    public Boolean deleteApplication(UUID applicationId) {
        if (!applicationRepository.existsById(applicationId)) {
            throw new IllegalStateException("application id " + applicationId + "does not exist");
        }
        applicationRepository.deleteById(applicationId);
        return true;
    }

    @Override
    public Application updateApplication(UUID applicationId, UpdateApplicationDto updateApplicationDto) {
        var optionalApplication = applicationRepository.findById(applicationId);
        if (optionalApplication.isEmpty()) {
            return null;
        }
        var application = optionalApplication.get();
        application.setName(updateApplicationDto.getName() == null ? application.getName() : updateApplicationDto.getName());
        var result = applicationRepository.save(application);
        return result;
    }
}
