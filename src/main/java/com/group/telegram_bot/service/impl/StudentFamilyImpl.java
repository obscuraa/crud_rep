package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.repository.StudentFamilyRepository;
import com.group.telegram_bot.dto.studentFamily.CreateStudentFamilyDto;
import com.group.telegram_bot.dto.studentFamily.UpdateStudentFamilyDto;
import com.group.telegram_bot.mapper.StudentFamilyMapper;
import com.group.telegram_bot.model.StudentFamily;
import com.group.telegram_bot.service.StudentFamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentFamilyImpl implements StudentFamilyService {
    private final StudentFamilyRepository studentFamilyRepository;
    private final StudentFamilyMapper studentFamilyMapper;

    @Override
    public List<StudentFamily> getStudentFamilies() {
        return studentFamilyRepository.findAll();
    }

    @Override
    public StudentFamily findStudentFamilyById(UUID studentFamilyId) {
        return studentFamilyRepository.findById(studentFamilyId).orElse(null);
    }

    @Override
    public StudentFamily addNewStudentFamily(CreateStudentFamilyDto createStudentFamilyDto) {
        StudentFamily studentFamily = studentFamilyMapper.createDtoToEntity(createStudentFamilyDto);

        var result = studentFamilyRepository.save(studentFamily);
        return result;
    }

    @Override
    public Boolean deleteStudentFamily(UUID studentFamilyId) {
        if (!studentFamilyRepository.existsById(studentFamilyId)) {
            throw new IllegalStateException("studentFamily id " + studentFamilyId + "does not exist");
        }
        studentFamilyRepository.deleteById(studentFamilyId);
        return true;
    }

    @Override
    public StudentFamily updateStudentFamily(UUID studentFamilyId, UpdateStudentFamilyDto updateStudentFamilyDto) {
        var optionalStudentFamily = studentFamilyRepository.findById(studentFamilyId);
        if (optionalStudentFamily.isEmpty()) {
            return null;
        }
        var studentFamily = optionalStudentFamily.get();
        studentFamily.setFullName(updateStudentFamilyDto.getFullName() == null ? studentFamily.getFullName() : updateStudentFamilyDto.getFullName());
        var result = studentFamilyRepository.save(studentFamily);
        return result;
    }
}
