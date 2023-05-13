package com.group.telegram_bot.model.projection;

public interface AcademicPerformanceInfoProjection {
    int getFinalPerformance();

    int getCurrentPerformance();

    String getSemesterPerformance();

    String getDebt();

    void setFinalPerformance(int finalPerformance);

    void setCurrentPerformance(int currentPerformance);

    void setSemesterPerformance(java.util.List<Object> semesterPerformance);

    void setDebt(String debt);
}
