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
@Table(schema = "scs", name = "platoon")
public class Platoon {
    @Id
    @Column(name = "platoon_id")
    int platoonId;

    @Column(name = "spec_id")
    int specId;
    @Column(name = "semester")
    int semester;
    @Column(name = "emp_id")
    int empId;
}
