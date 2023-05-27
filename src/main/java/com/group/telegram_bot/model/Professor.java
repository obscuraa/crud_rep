package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
