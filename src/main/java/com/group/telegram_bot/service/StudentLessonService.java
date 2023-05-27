package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.AttendanceDto;
import com.group.telegram_bot.model.Lesson;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.model.StudentLesson;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface StudentLessonService {

    StudentLesson addStudentLesson(UUID studentId, UUID lessonId);

    void skipLesson(UUID studentId, UUID lessonId, String cause);

    void skipLessonsInPeriod(UUID studentId, String cause, LocalDateTime from, LocalDateTime to);

    List<Lesson> getNearestLessons(UUID studentId);

    List<AttendanceDto> getAttendance(UUID studentId);

    List<Student> getStudentsByLessonId(UUID lessonId);

    void setAttendance(UUID lessonId, UUID studentId, Boolean isAbsent);

    void setMark(UUID lessonId, UUID studentId, Integer mark);

    void finishLessonById(UUID lessonId);
}
