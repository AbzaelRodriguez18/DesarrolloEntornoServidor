package daw2.dwes.morty1.service;

import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.repository.CharacterRepository;
import daw2.dwes.morty1.model.Character;
import daw2.dwes.morty1.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository CharacterRepository;
    private final LocationRepository LocationRepository;

    public CharacterService(CharacterRepository characterRepository, LocationRepository locationRepository) {
        CharacterRepository = characterRepository;
        LocationRepository = locationRepository;
    }


    public List<Character> findAll() {
        return CharacterRepository.findAll();
    }

    public Character findById(Long id) {
        return CharacterRepository.findById(id).orElse(null);
    }

    public void borrarPersonaje(Long id) {
        CharacterRepository.deleteById(id);
    }

    public void crearPersonajeConUbicacion(Character personaje, Location ubicacion) {
        Location ubicacionGuardada = LocationRepository.save(ubicacion);
        personaje.setLocation(ubicacionGuardada);
        CharacterRepository.save(personaje);
    }

    public List<Character> obtenerPersonajesMasAltosQue(Double altura) {
        return CharacterRepository.encontrarPorAlturaMayorQue(altura);
    }

    public List<Object[]> obtenerEstadisticasPersonajes() {
        return CharacterRepository.encontrarEstadisticasPersonajeUbicacionEpisodios();
    }
}


