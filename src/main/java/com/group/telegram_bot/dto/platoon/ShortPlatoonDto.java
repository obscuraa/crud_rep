package com.group.telegram_bot.dto.platoon;

import com.group.telegram_bot.dto.student.ShortStudentDto;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShortPlatoonDto {
    private UUID id;
    private String number;
    private ShortStudentDto commander;
}
