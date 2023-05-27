package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.model.Lesson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonsMapper {
    Lesson updateDtoToEntity(UpdateLessonsDto updateLessonsDto);

    FullLessonsDto toFullDto(Lesson lesson);

    Lesson createDtoToEntity(CreateLessonsDto createLessonsDto);

    List<FullLessonsDto> toListLessonsDto(List<Lesson> Lesson);
}
