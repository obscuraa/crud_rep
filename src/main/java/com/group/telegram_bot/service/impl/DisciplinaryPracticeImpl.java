package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.repository.DisciplinaryPracticeRepository;
import com.group.telegram_bot.dto.disciplinaryPractice.CreateDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.UpdateDisciplinaryPracticeDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.mapper.DisciplinaryPracticeMapper;
import com.group.telegram_bot.model.DisciplinaryPractice;
import com.group.telegram_bot.service.DisciplinaryPracticeService;
import com.group.telegram_bot.service.StudentService;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaryPracticeImpl implements DisciplinaryPracticeService {
    private final DisciplinaryPracticeMapper disciplinaryPracticeMapper;
    private final DisciplinaryPracticeRepository disciplinaryPracticeRepository;
    private final StudentService studentService;

    private final static String NOT_FOUND_MESSAGE = "Дисциплинарная практика [id = %s] не была обнаружена в базе данных";

    @Override
    public List<DisciplinaryPractice> getDisciplinaryPractices() {
        return disciplinaryPracticeRepository.findAll();
    }

    @Override
    public DisciplinaryPractice findDisciplinaryPracticeById(UUID disciplinaryPracticeId) {
        return disciplinaryPracticeRepository.findById(disciplinaryPracticeId)
            .orElseThrow(() -> new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, disciplinaryPracticeId)));
    }

    @Override
    public DisciplinaryPractice addNewDisciplinaryPractice(CreateDisciplinaryPracticeDto createDisciplinaryPracticeDto) {
        var disciplinaryPractice = disciplinaryPracticeMapper.createDtoToEntity(createDisciplinaryPracticeDto);
        return disciplinaryPracticeRepository.save(disciplinaryPractice);
    }

    @Override
    public void deleteDisciplinaryPractice(UUID disciplinaryPracticeId) {
        disciplinaryPracticeRepository.deleteById(disciplinaryPracticeId);
    }

    @Override
    public DisciplinaryPractice updateDisciplinaryPractice(UUID disciplinaryPracticeId, UpdateDisciplinaryPracticeDto updateDisciplinaryPracticeDto) {
        var optionalDisciplinaryPractice = disciplinaryPracticeRepository.findById(disciplinaryPracticeId);
        if (optionalDisciplinaryPractice.isPresent()) {
            var disciplinaryPractice = optionalDisciplinaryPractice.get();
            if (updateDisciplinaryPracticeDto.getPracticeType() != null) {
                disciplinaryPractice.setPracticeType(updateDisciplinaryPracticeDto.getPracticeType());
            }
            if (updateDisciplinaryPracticeDto.getCause() != null) {
                disciplinaryPractice.setCause(updateDisciplinaryPracticeDto.getCause());
            }
            return disciplinaryPracticeRepository.save(disciplinaryPractice);
        }
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, disciplinaryPracticeId));
    }

    @Override
    public DisciplinaryPractice addStudent(UUID disciplinaryPracticeId, UUID studentId) {
        AtomicReference<DisciplinaryPractice> result = null;
        disciplinaryPracticeRepository.findById(disciplinaryPracticeId)
            .ifPresent(disciplinaryPractice -> {
                var student = studentService.findStudentById(studentId);
                disciplinaryPractice.getStudents().add(student);
                result.set(disciplinaryPracticeRepository.save(disciplinaryPractice));
            });
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, disciplinaryPracticeId));
    }
}
