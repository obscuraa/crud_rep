package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = "scs", name = "")
public class Squad {
    @Id
    @Column(name = "squad_id")
    int squadId;

    @Column(name = "platoon_id")
    int platoonId;
    @Column(name = "number")
    int number;
    @Column(name = "com_id")
    String comId;
}
