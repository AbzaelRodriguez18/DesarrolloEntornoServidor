package com.example.heroquesttracker.Controlador;

import com.example.heroquesttracker.Modelos.Hero;
import com.example.heroquesttracker.Servicios.HeroService;
import com.example.heroquesttracker.Servicios.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorldController {

    private final HeroService heroService;
    private final QuestService questService;

    public WorldController(HeroService heroService, QuestService questService) {
        this.heroService = heroService;
        this.questService = questService;
    }


    @GetMapping("/heroes/initialize")
    public String initializeHeroes(Model model) {

        heroService.initializeHeroes();

        model.addAttribute("heroes", heroService.getAllHeroes());

        return "hero-list";
    }


    @GetMapping("/heroes")
    public String getAllHeroes(Model model) {

        model.addAttribute("heroes", heroService.getAllHeroes());

        return "hero-list";
    }


    @GetMapping("/quests")
    public String getAllQuests(Model model) {

        model.addAttribute("quests", questService.getAllQuests());

        return "quest-list";
    }


    @GetMapping("/quests/new")
    public String createNewQuest(Model model) {

        questService.createRandomQuest();

        model.addAttribute("quests", questService.getAllQuests());

        return "quest-list";
    }


    @GetMapping("/heroes/{name}")
    public String getHero(@PathVariable String name, Model model) {

        Hero hero = heroService.getHero(name);

        model.addAttribute("hero", hero);

        return "hero-detail";
    }


    @GetMapping("/quests/solve/{id}")
    public String solveQuest(@PathVariable Long id) {

        questService.markQuestAsSolved(id);

        return "redirect:/quests";
    }


    @GetMapping("/quests/fail/{id}")
    public String failQuest(@PathVariable Long id) {

        questService.failQuest(id);

        return "redirect:/quests";
    }
}
