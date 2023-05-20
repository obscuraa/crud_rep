package com.group.telegram_bot.dto.disciplinaryPractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateDisciplinaryPracticeDto {
    private String cause;
    private String practiceType;
}
