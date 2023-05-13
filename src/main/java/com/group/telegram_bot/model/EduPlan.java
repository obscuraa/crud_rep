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
@Table(schema = "scs", name = "edu_plan")
public class EduPlan {
    @Id
    @Column(name = "plan_id")
    int planId;

    @Column(name = "spec_id")
    int specId;
    @Column(name = "disc_id")
    int disciplineId;
    @Column(name = "semester")
    int semester;
    @Column(name = "total_hours")
    int totalHours;
}
