package daw2.dwes.morty1.repository;

import daw2.dwes.morty1.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Query("SELECT e FROM Episode e WHERE e.airDate > :fecha")
    List<Episode> encontrarPorFechaEmisionPosteriorA(@Param("fecha") String fecha);
}