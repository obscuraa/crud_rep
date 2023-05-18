package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "student")
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "birthdate")
    private LocalDateTime birthdate;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "VUC")
    private String VUC;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "role")
    private String role;
    @Column(name = "platoon")
    private String platoon;
    @Column(name = "course")
    private int course;
    @Column(name = "institute")
    private String institute;
    @Column(name = "military_education")
    private String militaryEducation;

    @ManyToOne
    @JoinColumn(name="disciplinary_practice_id")
    private DisciplinaryPractice disciplinaryPractice;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    @OneToMany(mappedBy = "student")
    private List<StudentFamily> studentFamilies;

    @ManyToMany(mappedBy = "students")
    private List<Club> clubs;

    @ManyToMany
    private Set<Lessons> lessons;

    @ManyToOne
    private Group group;
}