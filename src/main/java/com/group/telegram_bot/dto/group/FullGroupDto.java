package com.group.telegram_bot.dto.group;

import com.group.telegram_bot.dto.student.ShortStudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FullGroupDto {
    private UUID id;
    private String name;
    private int number;
    private ShortStudentDto commander;
    private List<ShortStudentDto> students;
}
