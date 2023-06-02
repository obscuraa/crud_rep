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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Table(schema = "public", name = "student_family")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentFamily {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "address")
    private String address;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "relative_role")
    private String relativeRole;

    @ManyToOne
    private Student student;
}
