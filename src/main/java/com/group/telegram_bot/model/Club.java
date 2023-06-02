package com.group.telegram_bot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    }
}
