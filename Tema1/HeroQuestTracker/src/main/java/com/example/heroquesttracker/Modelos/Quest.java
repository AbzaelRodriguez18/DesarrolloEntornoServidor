package com.example.heroquesttracker.Modelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Quest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean solved;
    private float experience;

    @ManyToOne
    @JoinColumn(name = "hero_name")
    private Hero hero;


    public Quest(String title, boolean solved, float experience, Hero hero) {
        this.title = title;
        this.solved = solved;
        this.experience = experience;
        this.hero = hero;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

}