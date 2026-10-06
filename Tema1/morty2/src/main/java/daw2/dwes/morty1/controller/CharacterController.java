package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.model.Character;
import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("characters", service.findAll());
        return "characters/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("character", service.findById(id));
        return "characters/detail";
    }
    @GetMapping("/delete/{id}")
    public String borrarPersonaje(@PathVariable Long id) {
        service.borrarPersonaje(id);
        return "redirect:/episodes/list";
    }

    @GetMapping("/create")
    public String crearPersonajeConUbicacion() {
        Location ubicacion = new Location();
        ubicacion.setName("Planeta Hardcoded");
        ubicacion.setDimension("Dimensión X");

        Character personaje = new Character();
        personaje.setName("Personaje Nuevo");
        personaje.setHeight(1.80f);
        personaje.setSpecies("Alien");

        service.crearPersonajeConUbicacion(personaje, ubicacion);

        return "redirect:/characters/list";
    }

    @GetMapping("/list")
    public String listarPersonajes(Model modelo) {
        modelo.addAttribute("characters", service.obtenerPersonajesMasAltosQue(1.70));
        return "characters/list";
    }

    @GetMapping("/stats")
    public String estadisticasPersonajes(Model modelo) {
        modelo.addAttribute("stats", service.obtenerEstadisticasPersonajes());
        return "characters/stats";
    }
}

