package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.dto.student.AuthorizeStudentDto;
import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.exceptions.NotFoundException;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.model.StudentFamily;
import com.group.telegram_bot.repository.StudentRepository;
import com.group.telegram_bot.service.StudentFamilyService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static com.group.telegram_bot.config.ErrorMessages.USER_NOT_FOUND_BY_EMAIL;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentFamilyService studentFamilyService;
    private final TokenService tokenService;


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(UUID studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new NotFoundDbObject("Student not found. Id = " + studentId));
    }

    @Override
    public Student addNewStudent(CreateStudentDto createStudentDto, HttpServletResponse response) {
        Student student = studentMapper.createDtoToEntity(createStudentDto);
        response.addHeader("Authorization", generateJwt(createStudentDto.getEmail(), createStudentDto.getRole().name()));
        return studentRepository.save(student);
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
        return studentRepository.save(student);
    }

    @Override
    public Student addLessons(UUID studentId, List<UUID> lessonsIds) {
//        var optionalStudent = studentRepository.findById(studentId);
//
//        if(optionalStudent.isPresent()){
//            Student student = optionalStudent.get();
//
//            var lessons = new ArrayList<Lessons>();
//            for (UUID lessonsId : lessonsIds) {
//                Lessons lesson = lessonsService.findLessonsById(lessonsId);
//                lessons.add(lesson);
//            }
//
//            student.addLessons((Set<Lessons>) lessons);
//            return studentRepository.save(student);
//        }
//        throw new IllegalArgumentException("student id " + studentId + " not found");
        return null;
    }

    @Override
    public Student addStudentFamilyByIds(UUID studentId, List<UUID> studentFamilyIds) {
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

    @Override
    public void addStudentFamily(UUID studentId, StudentFamily studentFamily) {
        var student = studentRepository.findById(studentId)
            .orElseThrow(() -> new NotFoundDbObject("ADDFAMILY: Student not found"));
        student.addStudentFamilies(List.of(studentFamily));
        studentRepository.save(student);
    }

    @Override
    public Student getStudentByTelephone(String telephone) {
        return studentRepository.findByTelephone(telephone).orElseThrow(() -> new NoSuchElementException("Telephone not found"));
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Email not found"));
    }

    @Override
    public String authorizeStudent(AuthorizeStudentDto authorizeStudentDto) {
        Student student = studentRepository.findByEmail(authorizeStudentDto.getEmail())
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_BY_EMAIL, authorizeStudentDto.getEmail()));
        return generateJwt(student.getEmail(), student.getRole());
    }

    private String generateJwt(String email, String role) {
        return "Bearer " + tokenService.generateToken(email, role);
    }
}
