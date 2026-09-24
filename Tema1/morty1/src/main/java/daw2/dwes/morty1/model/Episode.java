package daw2.dwes.morty1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "episodes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "episode_name", nullable = false, length = 255)
    private String name;

    @Column(name = "air_date")
    private Date airDate;

    @Column(name = "episode_code", length = 255)
    private String episodeCode;
}


