package com.group.telegram_bot.dto.group;

import com.group.telegram_bot.dto.student.ShortStudentDto;
import lombok.*;

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
}
