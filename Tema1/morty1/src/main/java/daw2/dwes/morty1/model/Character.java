package daw2.dwes.morty1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "character_name", nullable = false, length = 255)
    private String name;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "species", length = 255)
    private String species;

    @Column(name = "character_type", length = 255)
    private String character_type;

    @Column(name = "gender", length = 255)
    private String gender;

    @Column(name = "location_id")
    private int location_id;

    @Column(name = "image_url", length = 255)
    private String image_url;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;


}


