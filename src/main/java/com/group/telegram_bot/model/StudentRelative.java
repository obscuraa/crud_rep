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
@Table(schema = "scs", name = "student_relative")
public class StudentRelative {
    @Id
    int id;

    @Column(name = "stud_id")
    String studentId;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "addr")
    String addr;
    @Column(name = "phone")
    String phone;
    @Column(name = "who_is")
    String whoIs;
}
