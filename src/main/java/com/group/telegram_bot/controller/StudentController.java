package com.group.telegram_bot.controller;

import com.group.telegram_bot.Repository.StudentRepository;
import com.group.telegram_bot.dto.FullStudentInfo;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final FullStudentInfo fullStudentInfo;
    private final StudentRepository studentRepository;

    @GetMapping(path = "{stud_id}")
    public FullStudentInfo findStudent(@PathVariable String stud_id){
        return fullStudentInfo;
    }

    @PostMapping
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{clientId}")
    public void deleteStudent(@PathVariable("stud_id") String stud_id){
        studentService.deleteStudent(stud_id);
    }

    @PutMapping(path = "{stud_id}")
    public Student updateStudent(
            @PathVariable("stud_id") String stud_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname) {
        return studentService.updateStudent(stud_id, name, surname);
    }
}
