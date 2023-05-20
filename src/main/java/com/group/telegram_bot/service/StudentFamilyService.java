package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.studentFamily.CreateStudentFamilyDto;
import com.group.telegram_bot.dto.studentFamily.UpdateStudentFamilyDto;
import com.group.telegram_bot.model.StudentFamily;

import java.util.List;
import java.util.UUID;

public interface StudentFamilyService {
    List<StudentFamily> getStudentFamilies();

    StudentFamily findStudentFamilyById(UUID studentFamilyId);

    StudentFamily addNewStudentFamily(CreateStudentFamilyDto createStudentFamilyDto);

    Boolean deleteStudentFamily(UUID studentFamilyId);

    StudentFamily updateStudentFamily(UUID studentFamilyId, UpdateStudentFamilyDto updateStudentFamilyDto);
}
