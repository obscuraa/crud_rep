package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.application.CreateApplicationDto;
import com.group.telegram_bot.dto.application.FullApplicationDto;
import com.group.telegram_bot.dto.application.UpdateApplicationDto;
import com.group.telegram_bot.mapper.ApplicationMapper;
import com.group.telegram_bot.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    @GetMapping
    public List<FullApplicationDto> getApplication() {
        return applicationMapper.toListApplicationDto(applicationService.getApplications());
    }

    @GetMapping(path = "/{applicationId}")
    public FullApplicationDto findApplicationById(@PathVariable("applicationId") UUID applicationID) {
        return applicationMapper.toFullDto(applicationService.findApplicationById(applicationID));
    }

    @PostMapping
    public FullApplicationDto addNewApplication(@RequestBody CreateApplicationDto application) {
        return applicationMapper.toFullDto(applicationService.addNewApplication(application));
    }

    @DeleteMapping(path = "{applicationId}")
    public Boolean deleteApplication(@PathVariable("applicationId") UUID applicationId) {
        return applicationService.deleteApplication(applicationId);
    }

    @PutMapping(path = "{applicationId}")
    public FullApplicationDto updateApplication(
            @PathVariable("applicationId") UUID applicationId,
            @RequestBody UpdateApplicationDto updateApplicationDto) {
        return applicationMapper.toFullDto(applicationService.updateApplication(applicationId, updateApplicationDto));
    }
}
