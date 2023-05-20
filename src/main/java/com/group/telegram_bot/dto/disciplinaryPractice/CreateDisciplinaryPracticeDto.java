package com.group.telegram_bot.dto.disciplinaryPractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateDisciplinaryPracticeDto {
    private UUID id;
    private String cause;
    private String practiceType;
}
