package com.group.telegram_bot.dto;

import com.group.telegram_bot.model.projection.AcademicPerformanceInfoProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicPerformanceInfo implements AcademicPerformanceInfoProjection {
    public int finalPerformance;
    public int currentPerformance;
    public String semesterPerformance;
    public String debt;

    @Override
    public void setSemesterPerformance(List<Object> semesterPerformance) {

    }
}
