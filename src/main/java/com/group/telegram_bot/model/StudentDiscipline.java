package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = "scs", name = "student_discipline")
public class StudentDiscipline {
    @Id
    @Column(name = "disc_id")
    int discId;
    @Column(name = "stud_id")
    String studentId;
    @Column(name = "type")
    int type;
    @Column(name = "prepod_id")
    int prepodId;
    @Column(name = "reason")
    String reason;
    @Column(name = "fulfillment")
    String fulfillment;
}
