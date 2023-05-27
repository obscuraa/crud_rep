package com.group.telegram_bot.dto.lessons;

import java.time.LocalDateTime;
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
public class FullLessonsDto {
    private UUID id;
    private LocalDateTime created;
    private UUID professorId;
    private String subjectType;
}
