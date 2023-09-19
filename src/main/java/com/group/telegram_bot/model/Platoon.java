package com.group.telegram_bot.model;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(schema = "public", name = "platoon")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Platoon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "number")
    private String number;

    @OneToOne
    @JoinColumn(columnDefinition = "commander_id")
    private Student commander;

    @OneToMany(mappedBy = "platoon")
    private List<Group> groups;

}
