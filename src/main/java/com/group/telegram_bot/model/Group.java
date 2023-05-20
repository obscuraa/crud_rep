package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "groups")
    private List<Professor> professors;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public void addStudents(List<Student> students){
        this.students.addAll(students);
    };
}
