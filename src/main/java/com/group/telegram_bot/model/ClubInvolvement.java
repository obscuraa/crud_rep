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
@Table(schema = "scs", name = "club_involvement")
public class ClubInvolvement {
    @Id
    @Column(name = "inv_id")
    int invId;

    @Column(name = "stud_id")
    String studentId;
    @Column(name = "role")
    String role;
}
