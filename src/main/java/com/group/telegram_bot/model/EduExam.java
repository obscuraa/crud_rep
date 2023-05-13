package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "scs", name = "edu_exam")
public class EduExam {
    @Id
    @Column(name = "exam_id")
    int examId;

    @Column(name = "stud_id")
    String studentId;
    @Column(name = "plan_id")
    int planId;
    @Column(name = "amount")
    int amount;
}
