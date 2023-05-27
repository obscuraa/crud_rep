package com.group.telegram_bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(schema = "public", name = "club")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "directorName")
    private String directorName;

    @ManyToMany
    private List<Student> members;

    public void addMembers(List<Student> newMembers){
        this.members.addAll(newMembers);
    };
}
