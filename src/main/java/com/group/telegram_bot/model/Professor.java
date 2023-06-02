package com.group.telegram_bot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Setter
@Getter
@Table(schema = "public", name = "professor")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "telegram_id")
    private String telegramId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
