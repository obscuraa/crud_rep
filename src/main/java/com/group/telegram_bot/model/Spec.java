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
@Table(schema = "scs", name = "spec")
public class Spec {
    @Id
    @Column(name = "spec_id")
    int specId;
    @Column(name = "name")
    String name;
    @Column(name = "rank")
    String rank;
    @Column(name = "period")
    int period;
}
