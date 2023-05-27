package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.model.Student;

import com.group.telegram_bot.model.StudentFamily;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getStudents();

    Student findStudentById(UUID studentId);

    Student addNewStudent(CreateStudentDto createStudentDto);

    Boolean deleteStudent(UUID studentId);

    Student updateStudent(UUID studentId, UpdateStudentDto updateStudentDto);

    Student addLessons(UUID studentId, List<UUID> lessonsIds);

    Student addStudentFamilyByIds(UUID studentId, List<UUID> studentFamilyIds);

    void addStudentFamily(UUID studentId, StudentFamily studentFamily);
}
