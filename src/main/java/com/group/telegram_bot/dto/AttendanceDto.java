package com.group.telegram_bot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
    private String subjectType;
    private Float absoluteAttendance;
    private Float relativeAttendance;
}
