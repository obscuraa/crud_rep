package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.model.Lessons;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonsMapper {
    Lessons updateDtoToEntity(UpdateLessonsDto updateLessonsDto);

    FullLessonsDto toFullDto(Lessons lessons);

    Lessons createDtoToEntity(CreateLessonsDto createLessonsDto);

    List<FullLessonsDto> toListLessonsDto(List<Lessons> Lessons);
}
