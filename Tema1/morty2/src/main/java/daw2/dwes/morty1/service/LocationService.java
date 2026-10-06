package daw2.dwes.morty1.service;

import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void actualizarNombreUbicacion(Long id, String nuevoNombre) {
        Optional<Location> ubicacionOpcional = repository.findById(id);
        if (ubicacionOpcional.isPresent()) {
            Location ubicacion = ubicacionOpcional.get();
            ubicacion.setName(nuevoNombre);
            repository.save(ubicacion);
        }
    }

    public List<Location> obtenerUbicacionesConHumanos() {
        return repository.encontrarUbicacionesConHumanos();
    }
}

