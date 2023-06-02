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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Table(schema = "public", name = "group")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public void addStudents(List<Student> students) {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        this.students.addAll(students);
    }
}
