package com.example.heroquesttracker.Servicios;

import com.example.heroquesttracker.Modelos.Hero;
import com.example.heroquesttracker.Repositorios.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public void initializeHeroes() {
        if (heroRepository.count() > 0) {
            return;
        }

        Hero gandalf = new Hero("Gandalf", "Mago", 1, 0);
        Hero aragorn = new Hero("Aragorn", "Guerrero", 1, 0);
        Hero legolas = new Hero("Legolas", "Arquero", 1, 0);
        Hero frodo = new Hero("Frodo", "Hobbit", 1, 0);

        heroRepository.save(gandalf);
        heroRepository.save(aragorn);
        heroRepository.save(legolas);
        heroRepository.save(frodo);
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero getHero(String name) {
        return heroRepository.findById(name)
                .orElse(null);
    }

    public void addExperience(Hero hero, float xp) {
        hero.addExperience(xp);
        heroRepository.save(hero);
    }
}