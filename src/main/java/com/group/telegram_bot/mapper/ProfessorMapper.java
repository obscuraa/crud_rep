package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.professor.CreateProfessorDto;
import com.group.telegram_bot.dto.professor.FullProfessorDto;
import com.group.telegram_bot.model.Professor;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    FullProfessorDto toFullDto(Professor professor);

    Professor createDtoToEntity(CreateProfessorDto createProfessorDto);

    List<FullProfessorDto> toListProfessorDto(List<Professor> professors);
}
