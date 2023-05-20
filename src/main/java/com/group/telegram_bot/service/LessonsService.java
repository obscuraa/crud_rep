package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.model.Lessons;

import java.util.List;
import java.util.UUID;

public interface LessonsService {
    List<Lessons> getLessons();

    Lessons findLessonsById(UUID lessonsId);

    Lessons addNewLessons(CreateLessonsDto createLessonsDto);

    Boolean deleteLessons(UUID lessonsId);

    Lessons updateLessons(UUID lessonsId, UpdateLessonsDto updateLessonsDto);
}
