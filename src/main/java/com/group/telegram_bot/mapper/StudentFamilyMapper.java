package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.studentFamily.CreateStudentFamilyDto;
import com.group.telegram_bot.dto.studentFamily.FullStudentFamilyDto;
import com.group.telegram_bot.model.StudentFamily;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentFamilyMapper {
    FullStudentFamilyDto toFullDto(StudentFamily studentFamily);

    StudentFamily createDtoToEntity(CreateStudentFamilyDto createStudentFamilyDto);

    List<FullStudentFamilyDto> toListStudentFamilyDto(List<StudentFamily> studentFamilies);
}
