package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.CreateLessonFromProfessorDto;
import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.model.Lesson;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    List<Lesson> getLessons();

    Lesson findLessonsById(UUID lessonsId);

    Lesson addNewLessons(CreateLessonsDto createLessonsDto);

    Boolean deleteLessons(UUID lessonsId);

    Lesson updateLessons(UUID lessonsId, UpdateLessonsDto updateLessonsDto);

    void createLessons(CreateLessonFromProfessorDto createLessonFromProfessorDto);

    Lesson getNearestLesson(UUID professorId);
}
