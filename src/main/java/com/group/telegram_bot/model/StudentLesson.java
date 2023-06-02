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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(schema = "public", name = "student_lesson")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentLesson {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "cause")
    private String cause;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "is_absent", nullable = false)
    private Boolean isAbsent;

    @Column(name = "is_finished", nullable = false)
    private Boolean isFinished;
}
