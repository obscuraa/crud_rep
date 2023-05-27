package com.group.telegram_bot.service;

import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.UpdateProfessorDto;
import com.group.telegram_bot.model.Professor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProfessorService {
    List<Professor> getProfessors();

    Professor findProfessorById(UUID professorId);

    Professor addNewProfessor(CreateProfessorDto createProfessorDto);

    void deleteProfessor(UUID professorId);

    Professor updateProfessor(UUID professorId, UpdateProfessorDto updateProfessorDto);

    Professor addGroup(UUID professorId, UUID groupId);
}
