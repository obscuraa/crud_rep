package com.group.telegram_bot.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonFromProfessorDto {
    private List<LocalDateTime> schedule;
    private UUID professorId;
    private List<Integer> groupsNumber;
    private String subjectType;
}
