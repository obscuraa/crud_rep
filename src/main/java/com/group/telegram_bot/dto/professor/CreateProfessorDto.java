package com.group.telegram_bot.dto.professor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateProfessorDto {
    private String telegramId;
    private String fullName;
}
