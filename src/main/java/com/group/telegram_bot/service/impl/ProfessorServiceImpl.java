package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.repository.ProfessorRepository;
import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.UpdateProfessorDto;
import com.group.telegram_bot.exceptions.NotFoundDbObject;
import com.group.telegram_bot.mapper.ProfessorMapper;
import com.group.telegram_bot.model.Professor;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.ProfessorService;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    private final static String NOT_FOUND_MESSAGE = "Преподаватель [id = %s] не был обнаружен в базе данных";

    @Override
    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findProfessorById(UUID professorId) {
        return professorRepository.findById(professorId)
            .orElseThrow(() -> new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, professorId)));
    }

    @Override
    public Professor addNewProfessor(CreateProfessorDto createProfessorDto) {
        Professor professor = professorMapper.createDtoToEntity(createProfessorDto);
        return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(UUID professorId) {
        professorRepository.deleteById(professorId);
    }

    @Override
    public Professor updateProfessor(UUID professorId, UpdateProfessorDto updateProfessorDto) {
        AtomicReference<Professor> result = null;
        professorRepository.findById(professorId)
            .ifPresent(professor -> {
                if (updateProfessorDto.getFullName() != null) {
                    professor.setFullName(updateProfessorDto.getFullName());
                    result.set(professorRepository.save(professor));
                }
            });
        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, professorId));
    }

    @Override
    public Professor addGroup(UUID professorId, UUID groupId) {
        return null;
    }

//    @Override
//    public Professor addGroup(UUID professorId, UUID groupId) {
//        AtomicReference<Professor> result = null;
//        professorRepository.findById(professorId)
//            .ifPresent(professor -> {
//                var group = groupService.findGroupById(groupId);
//                //TODO: почему это не правильно?
//                professor.getGroups().add(group);
//                result.set(professorRepository.save(professor));
//            });
//        throw new NotFoundDbObject(String.format(NOT_FOUND_MESSAGE, professorId));
//    }
}
