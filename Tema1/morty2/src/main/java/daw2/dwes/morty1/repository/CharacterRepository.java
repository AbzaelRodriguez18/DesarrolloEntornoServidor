package daw2.dwes.morty1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import daw2.dwes.morty1.model.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query("SELECT c FROM Character c WHERE c.height > :altura")
    List<Character> encontrarPorAlturaMayorQue(@Param("altura") Double altura);

    @Query("SELECT c.name, l.name, SIZE(c.episodes) FROM Character c LEFT JOIN c.location l")
    List<Object[]> encontrarEstadisticasPersonajeUbicacionEpisodios();
}

