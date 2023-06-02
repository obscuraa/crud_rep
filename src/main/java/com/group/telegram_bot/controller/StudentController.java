package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.FullStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    public List<FullStudentDto> getStudents() {
        return studentMapper.toListStudentsDto((studentService.getStudents()));
    }

    @GetMapping(path = "/{studentId}")
    public FullStudentDto findStudentById(@PathVariable("studentId") UUID studentID) {
        return studentMapper.toFullDto(studentService.findStudentById(studentID));
    }

    @PostMapping
    public FullStudentDto addNewStudent(@RequestBody CreateStudentDto student, HttpServletResponse response) {
        return studentMapper.toFullDto(studentService.addNewStudent(student, response));
    }

    @DeleteMapping(path = "{studentId}")
    public Boolean deleteStudent(@PathVariable("studentId") UUID studentId) {
        return studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public FullStudentDto updateStudent(
            @PathVariable("studentId") UUID studentId,
            @RequestBody UpdateStudentDto updateStudentDto) {
        return studentMapper.toFullDto(studentService.updateStudent(studentId, updateStudentDto));
    }

    @PutMapping(path = "/{studentId}/lessons")
    public FullStudentDto addLessons(@PathVariable("studentId") UUID studentId, @RequestBody List<UUID> lessonsIds){
        return studentMapper.toFullDto(studentService.addLessons(studentId, lessonsIds));
    }

    @PutMapping(path = "/{studentId}/student_family/{studentFamilyIds}")
    public FullStudentDto addStudentFamilies(@PathVariable("studentId") UUID studentId, @RequestBody List<UUID> studentFamilyIds){
        return studentMapper.toFullDto(studentService.addLessons(studentId, studentFamilyIds));
    }
}
