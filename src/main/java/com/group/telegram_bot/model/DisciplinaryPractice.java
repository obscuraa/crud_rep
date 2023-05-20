package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Table(schema = "public", name = "disciplinaryPractice")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaryPractice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "cause")
    private String cause;
    @Column(name = "practice_type")
    private String practiceType;

    @OneToMany(mappedBy = "disciplinaryPractice")
    private List<Student> students;

    public void addStudents(List<Student> newStudents){
        this.students.addAll(newStudents);
    };
}
