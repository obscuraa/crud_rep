package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.DisciplinaryPracticeRepository;
import com.group.telegram_bot.dto.disciplinaryPractice.CreateDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.UpdateDisciplinaryPracticeDto;
import com.group.telegram_bot.mapper.DisciplinaryPracticeMapper;
import com.group.telegram_bot.model.Club;
import com.group.telegram_bot.model.DisciplinaryPractice;
import com.group.telegram_bot.model.Student;
import com.group.telegram_bot.service.DisciplinaryPracticeService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DisciplinaryPracticeImpl implements DisciplinaryPracticeService {
    private final DisciplinaryPracticeMapper disciplinaryPracticeMapper;
    private final DisciplinaryPracticeRepository disciplinaryPracticeRepository;
    private final StudentService studentService;

    @Override
    public List<DisciplinaryPractice> getDisciplinaryPractices() {
        return disciplinaryPracticeRepository.findAll();
    }

    @Override
    public DisciplinaryPractice findDisciplinaryPracticeById(UUID disciplinaryPracticeId) {
        return disciplinaryPracticeRepository.findById(disciplinaryPracticeId).orElse(null);
    }

    @Override
    public DisciplinaryPractice addNewDisciplinaryPractice(CreateDisciplinaryPracticeDto createDisciplinaryPracticeDto) {
        DisciplinaryPractice disciplinaryPractice = disciplinaryPracticeMapper.createDtoToEntity(createDisciplinaryPracticeDto);

        var result = disciplinaryPracticeRepository.save(disciplinaryPractice);
        return result;
    }

    @Override
    public Boolean deleteDisciplinaryPractice(UUID disciplinaryPracticeId) {
        if (!disciplinaryPracticeRepository.existsById(disciplinaryPracticeId)) {
            throw new IllegalStateException("disciplinaryPractice id " + disciplinaryPracticeId + "does not exist");
        }
        disciplinaryPracticeRepository.deleteById(disciplinaryPracticeId);
        return true;
    }

    @Override
    public DisciplinaryPractice updateDisciplinaryPractice(UUID disciplinaryPracticeId, UpdateDisciplinaryPracticeDto updateDisciplinaryPracticeDto) {
        var optionalDisciplinaryPractice = disciplinaryPracticeRepository.findById(disciplinaryPracticeId);
        if (optionalDisciplinaryPractice.isEmpty()) {
            return null;
        }
        var disciplinaryPractice = optionalDisciplinaryPractice.get();
        disciplinaryPractice.setCause(updateDisciplinaryPracticeDto.getCause() == null ? disciplinaryPractice.getCause() : updateDisciplinaryPracticeDto.getCause());
        var result = disciplinaryPracticeRepository.save(disciplinaryPractice);
        return result;
    }

    @Override
    public DisciplinaryPractice addStudents(UUID disciplinaryPracticeId, Set<UUID> studentIds) {
        var optionalDisciplinaryPractice = disciplinaryPracticeRepository.findById(disciplinaryPracticeId);

        if(optionalDisciplinaryPractice.isPresent()){
            DisciplinaryPractice disciplinaryPractice = optionalDisciplinaryPractice.get();

            var members = new ArrayList<Student>();
            for (UUID studentId : studentIds) {
                Student student = studentService.findStudentById(studentId);
                members.add(student);
            }
            disciplinaryPractice.addStudents(members);
            return disciplinaryPracticeRepository.save(disciplinaryPractice);
        }
        throw new IllegalArgumentException("disciplinaryPractice id " + disciplinaryPracticeId + " not found");
    }
}
