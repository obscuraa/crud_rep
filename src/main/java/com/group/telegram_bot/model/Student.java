package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(schema = "scs", name = "student")
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "stud_id")
    String studentId;

    @Column(name = "squad_id")
    int squadId;
    @Column(name = "surname")
    String surname;
    @Column(name = "name")
    String name;
    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "dob", columnDefinition = "DATE")
    LocalDateTime dob;
    @Column(name = "addr")
    String address;
    @Column(name = "phone")
    String phone;

    @Column(name = "uni_id")
    int uniId;
    @Column(name = "uni_group")
    String uniGroup;
}
