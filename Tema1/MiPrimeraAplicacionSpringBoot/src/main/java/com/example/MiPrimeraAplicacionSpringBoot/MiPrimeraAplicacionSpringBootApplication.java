package com.example.MiPrimeraAplicacionSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MiPrimeraAplicacionSpringBootApplication
        extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(MiPrimeraAplicacionSpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MiPrimeraAplicacionSpringBootApplication.class, args);
    }
}