package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("locations", service.findAll());
        return "locations/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("location", service.findById(id));
        return "locations/detail";
    }
    @GetMapping("/update/{id}")
    public String actualizarUbicacion(@PathVariable Long id) {
        service.actualizarNombreUbicacion(id, "Ubicación actualizada");
        return "redirect:/locations/detail/" + id;
    }

    @GetMapping("/list")
    public String listarUbicaciones(Model modelo) {
        modelo.addAttribute("locations", service.obtenerUbicacionesConHumanos());
        return "locations/list";
    }
}
