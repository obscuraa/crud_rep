package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.FullProfessorDto;
import com.group.telegram_bot.dto.professor.UpdateProfessorDto;
import com.group.telegram_bot.mapper.ProfessorMapper;
import com.group.telegram_bot.service.ProfessorService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @GetMapping
    public List<FullProfessorDto> getProfessors() {
        return professorMapper.toListProfessorDto(professorService.getProfessors());
    }

    @GetMapping(path = "/{professorId}")
    public FullProfessorDto findByProfessorId(@PathVariable("professorId") UUID professorId) {
        return professorMapper.toFullDto(professorService.findProfessorById(professorId));
    }

    @PutMapping(path = "/{professorId}/groups/{groupId}")
    public FullProfessorDto addGroups(@PathVariable("professorId") UUID professorId,
                                      @PathVariable("groupId") UUID groupId) {
        return professorMapper.toFullDto(professorService.addGroup(professorId, groupId));
    }

    @PostMapping
    public FullProfessorDto addNewProfessor(@RequestBody CreateProfessorDto professor) {
        return professorMapper.toFullDto(professorService.addNewProfessor(professor));
    }

    @DeleteMapping(path = "/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") UUID professorId) {
        professorService.deleteProfessor(professorId);
    }

    @PutMapping(path = "/{professorId}")
    public FullProfessorDto updateProfessor(@PathVariable("professorId") UUID professorId,
                                            @RequestBody UpdateProfessorDto updateProfessorDto) {
        return professorMapper.toFullDto(professorService.updateProfessor(professorId, updateProfessorDto));
    }
}
