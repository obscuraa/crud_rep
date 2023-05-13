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
@Table(schema = "scs", name = "uni")
public class Uni {
    @Id
    @Column(name = "uni_id")
    int uniId;

    @Column(name = "name")
    String name;
}
