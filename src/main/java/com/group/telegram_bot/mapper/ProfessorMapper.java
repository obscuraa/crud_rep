package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.FullProfessorDto;
import com.group.telegram_bot.dto.professor.UpdateProfessorDto;
import com.group.telegram_bot.model.Professor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    Professor updateDtoToEntity(UpdateProfessorDto updateProfessorDto);

    FullProfessorDto toFullDto(Professor professor);

    Professor createDtoToEntity(CreateProfessorDto createProfessorDto);

    List<FullProfessorDto> toListProfessorDto(List<Professor> professors);
}
