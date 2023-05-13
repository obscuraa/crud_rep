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
@Table(schema = "scs", name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    int empId;
    @Column(name = "surname")
    String surname;
    @Column(name = "name")
    String name;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "rank")
    String rank;
    @Column(name = "dep_id")
    int depId;
    @Column(name = "ac_rank")
    String acRank;
}
