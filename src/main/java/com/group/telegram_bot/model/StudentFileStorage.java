package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "scs", name = "student_file_storage")
public class StudentFileStorage {
    @Id
    @Column(name = "file_id")
    int fileId;

    byte[] document;
    @Column(name = "check_date")
    Timestamp checkDate;
    @Column(name = "checked_by")
    String checkedBy;
}
