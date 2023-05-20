package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.model.Professor;
import com.group.telegram_bot.model.Student;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface StudentService {
    List<Student> getStudents();

    Student findStudentById(UUID studentId);

    Student addNewStudent(CreateStudentDto createStudentDto);

    Boolean deleteStudent(UUID studentId);

    Student updateStudent(UUID studentId, UpdateStudentDto updateStudentDto);

    Student addLessons(UUID studentId, List<UUID> lessonsIds);

    Student addStudentFamily(UUID studentId, List<UUID> studentFamilyIds);
}
