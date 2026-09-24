package com.example.MiPrimeraAplicacionSpringBoot.Modelos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private String email;
}
