package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.studentFamily.CreateStudentFamilyDto;
import com.group.telegram_bot.dto.studentFamily.FullStudentFamilyDto;
import com.group.telegram_bot.dto.studentFamily.UpdateStudentFamilyDto;
import com.group.telegram_bot.mapper.StudentFamilyMapper;
import com.group.telegram_bot.service.StudentFamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/studentFamily")
@RequiredArgsConstructor
public class StudentFamilyController {
    private final StudentFamilyMapper studentFamilyMapper;
    private final StudentFamilyService studentFamilyService;

    @GetMapping
    public List<FullStudentFamilyDto> getStudentFamilies() {
        return studentFamilyMapper.toListStudentFamilyDto((studentFamilyService.getStudentFamilies()));
    }

    @GetMapping(path = "/{studentFamilyId}")
    public FullStudentFamilyDto findStudentFamilyById(@PathVariable("studentId") UUID studentFamilyID) {
        return studentFamilyMapper.toFullDto(studentFamilyService.findStudentFamilyById(studentFamilyID));
    }

    @PostMapping
    public FullStudentFamilyDto addNewStudentFamily(@RequestBody CreateStudentFamilyDto studentFamily) {
        return studentFamilyMapper.toFullDto(studentFamilyService.addNewStudentFamily(studentFamily));
    }

    @DeleteMapping(path = "{studentFamilyId}")
    public Boolean deleteStudentFamily(@PathVariable("studentFamilyId") UUID studentFamilyId) {
        return studentFamilyService.deleteStudentFamily(studentFamilyId);
    }

    @PutMapping(path = "{studentFamilyId}")
    public FullStudentFamilyDto updateStudentFamily(
            @PathVariable("studentFamilyId") UUID studentFamilyId,
            @RequestBody UpdateStudentFamilyDto updateStudentFamilyDto) {
        return studentFamilyMapper.toFullDto(studentFamilyService.updateStudentFamily(studentFamilyId, updateStudentFamilyDto));
    }
}
