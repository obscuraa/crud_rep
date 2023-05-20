package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.application.CreateApplicationDto;
import com.group.telegram_bot.dto.application.FullApplicationDto;
import com.group.telegram_bot.model.Application;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    //Application updateDtoToEntity(UpdateApplicationDto updateApplicationDto);

    FullApplicationDto toFullDto(Application application);

    Application createDtoToEntity(CreateApplicationDto createApplicationDto);

    List<FullApplicationDto> toListApplicationDto(List<Application> applications);
}
