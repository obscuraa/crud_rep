package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.disciplinaryPractice.CreateDisciplinaryPracticeDto;
import com.group.telegram_bot.dto.disciplinaryPractice.FullDisciplinaryPracticeDto;
import com.group.telegram_bot.model.DisciplinaryPractice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaryPracticeMapper {
    //DisciplinaryPractice updateDtoToEntity(UpdateDisciplinaryPracticeDto updateDisciplinaryPractice);

    FullDisciplinaryPracticeDto toFullDto(DisciplinaryPractice disciplinaryPractice);

    DisciplinaryPractice createDtoToEntity(CreateDisciplinaryPracticeDto createDisciplinaryPracticeDto);

    List<FullDisciplinaryPracticeDto> toListDisciplinaryPracticeDto(List<DisciplinaryPractice> DisciplinaryPractices);
}
