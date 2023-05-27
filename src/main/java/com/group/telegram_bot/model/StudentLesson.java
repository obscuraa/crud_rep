package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
