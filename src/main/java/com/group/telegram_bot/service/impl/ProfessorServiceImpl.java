package com.group.telegram_bot.service.impl;

import com.group.telegram_bot.Repository.ProfessorRepository;
import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.UpdateProfessorDto;
import com.group.telegram_bot.mapper.ProfessorMapper;
import com.group.telegram_bot.model.Group;
import com.group.telegram_bot.model.Professor;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final GroupService groupService;

    @Override
    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findProfessorById(UUID professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    @Override
    public Professor addNewProfessor(CreateProfessorDto createProfessorDto) {
        Professor professor = professorMapper.createDtoToEntity(createProfessorDto);

        var result = professorRepository.save(professor);
        return result;
    }

    @Override
    public Boolean deleteProfessor(UUID professorId) {
        if (!professorRepository.existsById(professorId)) {
            throw new IllegalStateException("professor id " + professorId + "does not exist");
        }
        professorRepository.deleteById(professorId);
        return true;
    }

    @Override
    public Professor updateProfessor(UUID professorId, UpdateProfessorDto updateProfessorDto) {
        var professor = professorRepository.findById(professorId);
        if (professor.isEmpty()){
            return null;
        }

        var updatedProfessor = professor.get();
        updatedProfessor.setFullName(updateProfessorDto.getFullName() != null ? updatedProfessor.getFullName() : updatedProfessor.getFullName());
        var result = professorRepository.save(updatedProfessor);
        return result;
    }

    @Override
    public Professor addGroups(UUID professorId, Set<UUID> groupIds) {
        var optionalProfessor = professorRepository.findById(professorId);

        if(optionalProfessor.isPresent()){
            Professor professor = optionalProfessor.get();

            var groups = new ArrayList<Group>();
            for (UUID groupId : groupIds) {
                Group group = groupService.findGroupById(groupId);
                groups.add(group);
            }
            professor.addGroups(groups);
            return professorRepository.save(professor);
        }
        throw new IllegalArgumentException("club id " + professorId + " not found");
    }
}
