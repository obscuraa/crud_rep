package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.dto.CreateLessonFromProfessorDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.repository.LessonsRepository;
import com.group.telegram_bot.dto.lessons.CreateLessonsDto;
import com.group.telegram_bot.dto.lessons.UpdateLessonsDto;
import com.group.telegram_bot.mapper.LessonsMapper;
import com.group.telegram_bot.model.Lesson;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.LessonService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonsMapper lessonsMapper;
    private final LessonsRepository lessonsRepository;
    private final GroupService groupService;

    @Override
    public List<Lesson> getLessons() {
        return lessonsRepository.findAll();
    }

    @Override
    public Lesson findLessonsById(UUID lessonsId) {
        return lessonsRepository.findById(lessonsId).orElse(null);
    }

    @Override
    public Lesson addNewLessons(CreateLessonsDto createLessonsDto) {
        Lesson lesson = lessonsMapper.createDtoToEntity(createLessonsDto);

        var result = lessonsRepository.save(lesson);
        return result;
    }

    @Override
    public Boolean deleteLessons(UUID lessonsId) {
        if (!lessonsRepository.existsById(lessonsId)) {
            throw new IllegalStateException("lessons id " + lessonsId + "does not exist");
        }
        lessonsRepository.deleteById(lessonsId);
        return true;
    }

    @Override
    public Lesson updateLessons(UUID lessonsId, UpdateLessonsDto updateLessonsDto) {
        var optionalLessons = lessonsRepository.findById(lessonsId);
        if (optionalLessons.isEmpty()) {
            return null;
        }
        var lessons = optionalLessons.get();
        var result = lessonsRepository.save(lessons);
        return result;
    }

    @Override
    public void createLessons(CreateLessonFromProfessorDto createLessonFromProfessorDto) {
        var students = new ArrayList<Student>();
        for (int groupNumber : createLessonFromProfessorDto.getGroupsNumber()) {
            students.addAll(groupService.findGroupByNumber(groupNumber).getStudents());
        }
        for (LocalDateTime created : createLessonFromProfessorDto.getSchedule()) {
            var lesson = new Lesson();
            lesson.setCreated(created);
            lesson.setProfessorId(createLessonFromProfessorDto.getProfessorId());
            lesson.setSubjectType(createLessonFromProfessorDto.getSubjectType());
            lesson.setStudents(new HashSet<>(students));
            lessonsRepository.save(lesson);
        }
    }

    @Override
    public Lesson getNearestLesson(UUID professorId) {
        return lessonsRepository.findTop1ByIdAndCreatedGreaterThan(professorId, LocalDateTime.now())
            .orElseThrow(() -> new NotFoundDbObject("Lesson greater that " + LocalDateTime.now() + " not found"));
    }
}
