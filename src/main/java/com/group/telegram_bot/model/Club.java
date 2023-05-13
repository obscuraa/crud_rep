package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(schema = "scs", name = "club")
@Entity
public class Club {
    @Id
    @Column(name = "club_id")
    int clubId;

    @Column(name = "emp_id")
    int empId;
    @Column(name = "name")
    String name;
}
