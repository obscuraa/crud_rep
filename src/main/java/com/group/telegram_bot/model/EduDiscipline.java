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
@Table(schema = "scs", name = "edu_discipline")
public class EduDiscipline {
    @Id
    @Column(name = "disc_id")
    int disciplineId;

    @Column(name = "dep_id")
    int employeeDepartmentId;
    @Column(name = "name")
    String name;
}
