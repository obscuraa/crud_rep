package com.group.telegram_bot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(schema = "public", name = "platoon")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Platoon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name="commander_id")
    private Student commander;
    @Column(name = "size")
    private int amount;

    @OneToMany(mappedBy = "platoon", cascade = CascadeType.ALL)
    private List<Group> groups = new ArrayList<>();

    public void addGroups(List<Group> groups) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.addAll(groups);
    }
}
