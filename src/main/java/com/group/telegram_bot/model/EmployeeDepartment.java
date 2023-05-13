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
@Table(schema = "scs", name = "employee_department")
public class EmployeeDepartment {
    @Id
    @Column(name = "dep_id")
    int depId;
    @Column(name = "name")
    String name;
}
