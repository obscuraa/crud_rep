package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "scs", name = "edu_lesson")
public class EduLesson {
    @Id
    @Column(name = "lesson_id")
    int lessonId;
    @Column(name = "platoon_id")
    int platoonId;
    @Column(name = "num")
    int num;
    @Column(name = "day_id", columnDefinition = "DATE")
    LocalDateTime day;
    @Column(name = "plan_id")
    int planId;
    @Column(name = "emp_id")
    int empId;
    @Column(name = "aud")
    int aud;
}
