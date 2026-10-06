package com.example.heroquesttracker.Servicios;


import com.example.heroquesttracker.Modelos.Hero;
import com.example.heroquesttracker.Modelos.Quest;
import com.example.heroquesttracker.Repositorios.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    private static final List<String> adjectives = List.of(
            "Lost", "Forbidden", "Ancient", "Cursed",
            "Hidden", "Glorious", "Frozen", "Burning"
    );

    private static final List<String> nouns = List.of(
            "Temple", "Blade", "Forest", "Scroll",
            "Beast", "Crown", "Crypt", "Dragon"
    );

    private static final List<String> actions = List.of(
            "Rescue", "Defeat", "Recover", "Explore",
            "Protect", "Destroy", "Uncover", "Seal"
    );

    private static final Random random = new Random();

    private final QuestRepository questRepository;
    private final HeroService heroService;

    public QuestService(QuestRepository questRepository,
                        HeroService heroService) {
        this.questRepository = questRepository;
        this.heroService = heroService;
    }

    public Quest createRandomQuest() {

        String title = generateTitle();

        // Experiencia entre 0 y 10 con un decimal
        float experience = Math.round(random.nextFloat() * 100) / 10.0f;

        // Seleccionamos un héroe aleatoriamente
        List<Hero> heroes = heroService.getAllHeroes();

        Hero hero = null;

        if (!heroes.isEmpty()) {
            hero = heroes.get(random.nextInt(heroes.size()));
        }

        Quest quest = new Quest(title, false, experience, hero);

        return questRepository.save(quest);
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public void markQuestAsSolved(Long id) {

        Quest quest = questRepository.findById(id)
                .orElse(null);

        if (quest == null) {
            return;
        }

        if (Boolean.TRUE.equals(quest.getSolved())) {
            return;
        }

        quest.setSolved(true);

        Hero hero = quest.getHero();

        if (hero != null) {
            heroService.addExperience(
                    hero,
                    quest.getExperience()
            );
        }

        questRepository.save(quest);
    }

    public void failQuest(Long id) {
        questRepository.deleteById(id);
    }

    private static String generateTitle() {
        String adjective =
                adjectives.get(random.nextInt(adjectives.size()));

        String noun =
                nouns.get(random.nextInt(nouns.size()));

        String action =
                actions.get(random.nextInt(actions.size()));

        return action + " the " + adjective + " " + noun;
    }
}