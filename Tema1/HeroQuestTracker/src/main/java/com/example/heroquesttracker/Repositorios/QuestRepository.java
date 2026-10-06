package com.example.heroquesttracker.Repositorios;

import com.example.heroquesttracker.Modelos.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {

}