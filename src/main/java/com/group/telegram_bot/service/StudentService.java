package com.group.telegram_bot.service;

import com.group.telegram_bot.Repository.StudentRepository;
import com.group.telegram_bot.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student findStudent(String studentId){
        return studentRepository.findById(studentId).orElseThrow();
    }

    public List<Student> getClients() {
        return studentRepository.findAll();
    }

    public Optional<Student> findDataById(String name){
        return studentRepository.findById("24");
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentByOptional = studentRepository.findById(student.getStudentId());
        if (studentByOptional.isPresent()){
            throw new IllegalStateException("такой студент уже есть");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(String studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("id студента " + studentId + " не существует");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student updateStudent(String studentId, String name, String surname) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("client with id " + studentId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (surname != null && surname.length() > 0 && !Objects.equals(student.getSurname(), surname)) {
            Optional<Student> studentOptional = studentRepository.findStudentBySurname(surname);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Такой студент уже есть");
            }
            student.setSurname(surname);
        }
        return student;
    }
}
