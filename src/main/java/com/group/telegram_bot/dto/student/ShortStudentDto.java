package com.group.telegram_bot.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShortStudentDto {
    private UUID id;
    private LocalDateTime birthdate;
    private String fullName;
    private String VUC;
    private String address;
    private String telephone;
    private String role;
    private String platoon;
    private int course;
    private String institute;
    private String militaryEducation;
}
