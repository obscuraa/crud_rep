package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "scs", name = "edu_poll")
public class EduPoll {
    @Id
    @Column(name = "poll_id")
    int pollId;

    @Column(name = "stud_id")
    String studentId;
    @Column(name = "amount")
    int amount;
    @Column(name = "reason")
    String reason;
    @Column(name = "lesson_id")
    int lessonId;
}
