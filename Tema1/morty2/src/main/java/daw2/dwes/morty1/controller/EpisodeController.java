package daw2.dwes.morty1.controller;

import daw2.dwes.morty1.model.Episode;
import daw2.dwes.morty1.service.EpisodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/episodes")
public class EpisodeController {
    private final EpisodeService service;

    public EpisodeController(EpisodeService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("episodes", service.findAll());
        return "episodes/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("episode", service.findById(id));
        return "episodes/detail";
    }

    @GetMapping("/create")
    public String crearEpisodio() {
        Episode episodio = new Episode();
        episodio.setName("Nuevo Episodio de Prueba");
        episodio.setAirDate(LocalDate.parse("2026-10-06"));
        service.crearEpisodio(episodio);

        return "redirect:/episodes/list";
    }


    @GetMapping("/list")
    public String listarEpisodios(Model modelo) {
        modelo.addAttribute("episodes", service.obtenerEpisodiosPosterioresAFecha("2015-12-31"));
        return "episodes/list";
    }

    @GetMapping("/total")
    public String mostrarTotalEpisodios(Model modelo) {
        modelo.addAttribute("total", service.obtenerTotalEpisodios());
        return "episodes/total";
    }
}