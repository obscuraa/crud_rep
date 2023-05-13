package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(schema = "scs", name = "student_abscence")
public class StudentAbscence {
    @Id
    @Column(name = "abs_id")
    int absId;

    String stud_id;
    @Column(name = "file_id")
    int fileId;
    @Column(name = "date_start", columnDefinition = "DATE")
    LocalDateTime start;
    @Column(name = "date_stop", columnDefinition = "DATE")
    LocalDateTime stop;
    @Column(name = "reason")
    String reason;
    @Column(name = "verified_by")
    String verifiedBy;
}
