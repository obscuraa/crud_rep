package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(schema = "scs", name = "work_day")
@Getter
@Setter

public class WorkDay {
    @Column(name = "day_id", columnDefinition = "DATE")
    @Id
    Date dayId;
    @Column(name = "platoon_id")
    int platoonId;
}
