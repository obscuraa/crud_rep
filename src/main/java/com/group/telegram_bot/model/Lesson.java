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
import java.time.LocalDateTime;
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
