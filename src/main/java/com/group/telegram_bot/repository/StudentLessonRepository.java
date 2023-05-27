package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Lesson;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.model.StudentLesson;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLessonRepository extends JpaRepository<StudentLesson, UUID> {
    // select * from student_lesson where student_id = {1} and lesson_id = {2}
    Optional<StudentLesson> findByStudentAndLesson(Student student, Lesson lesson);
    List<StudentLesson> findByStudentAndStartedAtBetween(Student student, LocalDateTime from, LocalDateTime to);
    List<StudentLesson> findTop10ByStudentAndIsFinishedOrderByStartedAt(Student student, Boolean isFinished);
    List<StudentLesson> findByStudent(Student student);
    List<StudentLesson> findByLesson(Lesson lesson);
}
