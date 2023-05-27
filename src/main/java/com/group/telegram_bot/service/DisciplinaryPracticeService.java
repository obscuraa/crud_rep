package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.disciplinaryPractice.CreateDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.UpdateDisciplinaryPracticeDto;
import com.group.telegram_bot.model.DisciplinaryPractice;

import java.util.List;
import java.util.UUID;

public interface DisciplinaryPracticeService {
    List<DisciplinaryPractice> getDisciplinaryPractices();

    DisciplinaryPractice findDisciplinaryPracticeById(UUID disciplinaryPracticeId);

    DisciplinaryPractice addNewDisciplinaryPractice(CreateDisciplinaryPracticeDto createDisciplinaryPracticeDto);

    void deleteDisciplinaryPractice(UUID disciplinaryPracticeId);

    DisciplinaryPractice updateDisciplinaryPractice(UUID disciplinaryPracticeId, UpdateDisciplinaryPracticeDto updateDisciplinaryPracticeDto);

    DisciplinaryPractice addStudent(UUID disciplinaryPracticeId, UUID studentId);
}
