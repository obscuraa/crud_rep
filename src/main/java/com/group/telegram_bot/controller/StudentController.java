package com.group.telegram_bot.controller;

import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

//    @PostMapping
//    public Student createStudent(){
//        //return Student;
//    }
}
