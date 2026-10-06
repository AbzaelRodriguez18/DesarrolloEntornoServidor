package com.example.heroquesttracker.Modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Hero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    @Id
    private String name;
    private String heroClass;
    private int nivel;
    private float experience;

    @OneToMany(mappedBy = "hero")
    private List<Quest> quests = new ArrayList<>();

    public Hero(String name, String heroClass, int nivel, float experience) {
        this.name = name;
        this.heroClass = heroClass;
        this.nivel = nivel;
        this.experience = experience;
    }


    public void addExperience(float xp) {
        this.experience += xp;
        this.nivel = (int) (this.experience / 10) + 1;
    }
}
