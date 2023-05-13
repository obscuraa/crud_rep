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
@Table(schema = "scs", name = "student_other_doc")
public class StudentOtherDoc {
    @Id
    @Column(name = "other_id")
    int otherId;
    @Column(name = "stud_id")
    String studentId;
    @Column(name = "file_id")
    int fileId;
    @Column(name = "doc_type")
    String docType;
    @Column(name = "verified_by")
    String verifiedBy;
}
