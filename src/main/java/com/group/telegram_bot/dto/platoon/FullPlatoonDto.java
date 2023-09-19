package com.group.telegram_bot.dto.platoon;

import com.group.telegram_bot.dto.group.FullGroupDto;
import com.group.telegram_bot.dto.student.ShortStudentDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FullPlatoonDto {
    private UUID id;
    private String number;
    private ShortStudentDto commander;
    private List<FullGroupDto> groups;
}
