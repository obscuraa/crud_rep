package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.CreateLessonFromProfessorDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.FullProfessorDto;
import com.group.telegram_bot.dto.student.ShortStudentDto;
import com.group.telegram_bot.mapper.LessonsMapper;
import com.group.telegram_bot.mapper.ProfessorMapper;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.service.LessonService;
import com.group.telegram_bot.service.ProfessorService;
import com.group.telegram_bot.service.StudentLessonService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/universal/professor")
public class UniversalProfessorController {

    private final LessonService lessonService;
    private final LessonsMapper lessonsMapper;
    private final StudentMapper studentMapper;
    private final StudentLessonService studentLessonService;
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @PostMapping(path = ":createProfessor")
    public FullProfessorDto createdProfessor(@RequestBody CreateProfessorDto createProfessorDto) {
        return professorMapper.toFullDto(professorService.addNewProfessor(createProfessorDto));
    }

    @PostMapping(path = ":createLessons")
    public void createLessons(@RequestBody CreateLessonFromProfessorDto createLessonFromProfessorDto) {
        lessonService.createLessons(createLessonFromProfessorDto);
    }

    @GetMapping(path = ":getNearestLesson")
    public FullLessonsDto getNearestLesson(@RequestParam(name = "professorId") UUID professorId) {
        return lessonsMapper.toFullDto(lessonService.getNearestLesson(professorId));
    }

    @GetMapping(path = ":getStudents")
    public List<ShortStudentDto> getStudentsByLessonId(@RequestParam(name = "lessonId") UUID lessonId) {
        return studentMapper.toShortDtoList(studentLessonService.getStudentsByLessonId(lessonId));
    }

    @PutMapping(path = ":setAttendance")
    public void setAttendance(@RequestParam(name = "lessonId") UUID lessonId,
                              @RequestParam(name = "studentId") UUID studentId,
                              @RequestParam(name = "isAbsent") Boolean isAbsent) {
        studentLessonService.setAttendance(lessonId, studentId, isAbsent);
    }

    @PutMapping(path = ":setMark")
    public void setMark(@RequestParam(name = "lessonId") UUID lessonId,
                              @RequestParam(name = "studentId") UUID studentId,
                              @RequestParam(name = "mark") Integer mark) {
        studentLessonService.setMark(lessonId, studentId, mark);
    }

    @PutMapping(path = ":finishLesson")
    public void finishLesson(@RequestParam(name = "lessonId") UUID lessonId) {
        studentLessonService.finishLessonById(lessonId);
    }
}
