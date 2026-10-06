package com.example.heroquesttracker.Repositorios;

import com.example.heroquesttracker.Modelos.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, String> {

}