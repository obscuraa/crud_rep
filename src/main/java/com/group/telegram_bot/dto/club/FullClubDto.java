package com.group.telegram_bot.dto.club;

import com.group.telegram_bot.dto.student.ShortStudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FullClubDto {
    private UUID id;
    private String directorName;
    private String name;
    private List<ShortStudentDto> members;
}
