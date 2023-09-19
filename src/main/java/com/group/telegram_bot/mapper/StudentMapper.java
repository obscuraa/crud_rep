package com.group.telegram_bot.mapper;

import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.FullStudentDto;
import com.group.telegram_bot.dto.student.ShortStudentDto;
import com.group.telegram_bot.dto.student.UpdateStudentDto;
import com.group.telegram_bot.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student updateDtoToEntity(UpdateStudentDto updateStudentDto);

    FullStudentDto toFullDto(Student student);

    Student createDtoToEntity(CreateStudentDto createStudentDto);

    @Mapping(target = "platoon", source = "student.group.platoon.number")
    ShortStudentDto toShortDto(Student student);

    List<FullStudentDto> toListStudentsDto(List<Student> students);

    List<ShortStudentDto> toShortDtoList(List<Student> students);
}
