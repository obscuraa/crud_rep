package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.dto.AttendanceDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.model.Lesson;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.model.StudentLesson;
import com.group.telegram_bot.repository.StudentLessonRepository;
import com.group.telegram_bot.service.LessonService;
import com.group.telegram_bot.service.StudentLessonService;
import com.group.telegram_bot.service.StudentService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLessonServiceImpl implements StudentLessonService {

    private final StudentLessonRepository studentLessonRepository;
    private final StudentService studentService;
    private final LessonService lessonService;

    @Override
    public StudentLesson addStudentLesson(UUID studentId, UUID lessonId) {
        return null;
    }

    @Override
    public void skipLesson(UUID studentId, UUID lessonId, String cause) {
        var student = studentService.findStudentById(studentId);
        var lesson = lessonService.findLessonsById(lessonId);
        var studentLesson = studentLessonRepository.findByStudentAndLesson(student, lesson)
            .orElseThrow(() -> new NotFoundDbObject("Student lesson not found"));
        setAbsent(studentLesson, cause);
    }

    @Override
    public void skipLessonsInPeriod(UUID studentId, String cause, LocalDateTime from, LocalDateTime to) {
        var student = studentService.findStudentById(studentId);
        var studentLessons = studentLessonRepository.findByStudentAndStartedAtBetween(student, from, to);
        for (StudentLesson studentLesson : studentLessons) {
            setAbsent(studentLesson, cause);
        }
    }

    @Override
    public List<Lesson> getNearestLessons(UUID studentId) {
        var student = studentService.findStudentById(studentId);
        return studentLessonRepository.findTop10ByStudentAndIsFinishedOrderByCreatedAt(student, false)
            .stream()
            .map(StudentLesson::getLesson)
            .collect(Collectors.toList());
    }

    @Override
    public List<AttendanceDto> getAttendance(UUID studentId) {
        var student = studentService.findStudentById(studentId);
        var studentLessons = studentLessonRepository.findByStudent(student);
        Map<String, Integer> all = new HashMap<>();
        Map<String, Integer> allWithoutFuture = new HashMap<>();
        Map<String, Integer> allAttendance = new HashMap<>();
        for (StudentLesson studentLesson : studentLessons) {
            var subjectType = studentLesson.getLesson().getSubjectType();

            if (all.containsKey(subjectType)) {
                all.put(subjectType, 1);
            } else {
                var value = all.get(subjectType) + 1;
                all.replace(subjectType, value);
            }

            if (studentLesson.getIsFinished() && allWithoutFuture.containsKey(subjectType)) {
                allWithoutFuture.put(subjectType, 1);
            } else if (studentLesson.getIsFinished()) {
                var value = allWithoutFuture.get(subjectType) + 1;
                allWithoutFuture.replace(subjectType, value);
            }

            if (studentLesson.getCause() == null && allAttendance.containsKey(subjectType)) {
                allAttendance.put(subjectType, 1);
            } else if (studentLesson.getCause() == null) {
                var value = allAttendance.get(subjectType) + 1;
                allAttendance.replace(subjectType, value);
            }
        }
        var result = new ArrayList<AttendanceDto>();
        for (Map.Entry<String, Integer> subject : all.entrySet()) {
            var subjectType = subject.getKey();
            result.add(AttendanceDto.builder()
                    .subjectType(subjectType)
                    .absoluteAttendance((float) allAttendance.getOrDefault(subjectType, 0) / subject.getValue())
                    .relativeAttendance((float) allAttendance.getOrDefault(subjectType, 0) / allWithoutFuture.getOrDefault(subjectType, 1000000))
                .build());
        }
        return result;
    }

    @Override
    public List<Student> getStudentsByLessonId(UUID lessonId) {
        var lesson = lessonService.findLessonsById(lessonId);
        return studentLessonRepository.findByLesson(lesson)
            .stream()
            .map(StudentLesson::getStudent)
            .collect(Collectors.toList());
    }

    @Override
    public void setAttendance(UUID lessonId, UUID studentId, Boolean isAbsent) {
        var student = studentService.findStudentById(studentId);
        var lesson = lessonService.findLessonsById(lessonId);
        var studentLesson = studentLessonRepository.findByStudentAndLesson(student, lesson)
            .orElseThrow(() -> new NotFoundDbObject("Student lesson not found"));
        studentLesson.setIsAbsent(isAbsent);
        studentLesson.setCause(isAbsent ? "Without respectful reason" : null);
        studentLessonRepository.save(studentLesson);

    }

    @Override
    public void setMark(UUID lessonId, UUID studentId, Integer mark) {
        var student = studentService.findStudentById(studentId);
        var lesson = lessonService.findLessonsById(lessonId);
        var studentLesson = studentLessonRepository.findByStudentAndLesson(student, lesson)
            .orElseThrow(() -> new NotFoundDbObject("Student lesson not found"));
        studentLesson.setMark(mark);
        studentLessonRepository.save(studentLesson);
    }

    @Override
    public void finishLessonById(UUID lessonId) {
        var lesson = lessonService.findLessonsById(lessonId);
        var lessons = studentLessonRepository.findByLesson(lesson);
        for (StudentLesson studentLesson : lessons) {
            studentLesson.setIsFinished(true);
            studentLessonRepository.save(studentLesson);
        }
    }

    private void setAbsent(StudentLesson studentLesson, String cause) {
        studentLesson.setCause(cause);
        studentLesson.setIsAbsent(true);
        studentLessonRepository.save(studentLesson);
    }

}
