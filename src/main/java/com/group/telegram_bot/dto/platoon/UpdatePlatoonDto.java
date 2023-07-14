package com.group.telegram_bot.dto.platoon;

import com.group.telegram_bot.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdatePlatoonDto {
    private String name;
    private Student commander;
    private int amount;
}
