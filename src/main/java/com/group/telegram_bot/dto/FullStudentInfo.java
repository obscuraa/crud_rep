package com.group.telegram_bot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullStudentInfo {
    public String name;
    public Date dob;
    public String VUC;
    public int VUCNumber;
    public String institute;
    public String course;
    public String group;
    public String specialty;
    public String militarySpecialty;
    public String platoon;
    public String jobTile;
    public String job;
    public String address;
    public String telephoneNumber;

    public MotherInfo motherInfo;
    public FatherInfo fatherInfo;
    public List<BrotherInfo> brotherInfo;
    public List<SisterInfo> sisterInfo;
    public List<RelativeInfo> relativeInfo;

    public AcademicPerformanceInfo academicPerformanceInfo;
    public DisciplinaryPractice disciplinaryPractice;
    public CircleActivity circleActivity;

    public String attendance;
    public String lessons;

}
