package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.StudentRepository;
import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.model.Club;
import com.group.telegram_bot.model.Lessons;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.model.StudentFamily;
import com.group.telegram_bot.service.LessonsService;
import com.group.telegram_bot.service.StudentFamilyService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.glassfish.grizzly.utils.ArraySet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final LessonsService lessonsService;
    private final StudentFamilyService studentFamilyService;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(UUID studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student addNewStudent(CreateStudentDto createStudentDto) {
        Student student = studentMapper.createDtoToEntity(createStudentDto);

        var result = studentRepository.save(student);
        return result;

    }

    @Override
    public Boolean deleteStudent(UUID studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student id " + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
        return true;
    }

    @Override
    public Student updateStudent(UUID studentId, UpdateStudentDto updateStudentDto) {
        var optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            return null;
        }
        var student = optionalStudent.get();
        student.setFullName(updateStudentDto.getFullName() == null ? student.getFullName() : updateStudentDto.getFullName());
        var result = studentRepository.save(student);
        return result;
    }

    @Override
    public Student addLessons(UUID studentId, List<UUID> lessonsIds) {
        var optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();

            var listoflessons = new ArrayList<Lessons>();
            for (UUID lessonsId : lessonsIds) {
                Lessons lesson = lessonsService.findLessonsById(studentId);
                listoflessons.add(lesson);
            }
            student.addLessons((Set<Lessons>) listoflessons);
            return studentRepository.save(student);
        }
        throw new IllegalArgumentException("student id " + studentId + " not found");
    }

    @Override
    public Student addStudentFamily(UUID studentId, List<UUID> studentFamilyIds) {
        var optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();

            var familyMembers = new ArrayList<StudentFamily>();
            for (UUID familyMemberId : studentFamilyIds) {
                StudentFamily familyMember = studentFamilyService.findStudentFamilyById(familyMemberId);
                familyMembers.add(familyMember);
            }
            student.addStudentFamilies(familyMembers);
            return studentRepository.save(student);
        }
        throw new IllegalArgumentException("student id " + studentId + " not found");
    }
}
