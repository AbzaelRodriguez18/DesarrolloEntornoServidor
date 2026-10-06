package daw2.dwes.morty1.repository;

import daw2.dwes.morty1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT DISTINCT l FROM Location l JOIN Character c ON c.location = l WHERE c.species = 'Human'")
    List<Location> encontrarUbicacionesConHumanos();
}

