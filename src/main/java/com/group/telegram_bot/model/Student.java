package com.group.telegram_bot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "telegram_id")
    private String telegramId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "student")
    private List<StudentFamily> studentFamilies;

    @ManyToMany(mappedBy = "members")
    private List<Club> clubs;

    @OneToMany(mappedBy = "student")
    private Set<StudentLesson> studentLessons;

    @ManyToOne
    private Group group;

    public void addStudentFamilies(List<StudentFamily> newStudentFamilies){
        this.studentFamilies.addAll(newStudentFamilies);
    }
    
}
