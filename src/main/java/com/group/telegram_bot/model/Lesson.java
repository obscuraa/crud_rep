package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table(schema = "public", name = "lessons")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "professor_id")
    private UUID professorId;

    @Column(name = "subject_type")
    private String subjectType;

    @OneToMany(mappedBy = "lesson")
    private Set<StudentLesson> studentLessons;
}