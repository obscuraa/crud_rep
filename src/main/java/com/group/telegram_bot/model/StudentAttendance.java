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
@Table(schema = "scs", name = "student_attendance")
public class StudentAttendance {

    @Id
    @Column(name = "att_id")
    int attId;
    @Column(name = "lesson_id")
    int lessonId;
    @Column(name = "stud_id")
    String studentId;
    @Column(name = "reason")
    String reason;
}
