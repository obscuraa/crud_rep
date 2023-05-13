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
@Table(schema = "scs", name = "user_acc")
public class UserAcc {
    @Id
    int id;

    @Column(name = "user_code")
    String userCode;
    @Column(name = "pass")
    String pass;
    @Column(name = "user_type")
    int user_type;
}
