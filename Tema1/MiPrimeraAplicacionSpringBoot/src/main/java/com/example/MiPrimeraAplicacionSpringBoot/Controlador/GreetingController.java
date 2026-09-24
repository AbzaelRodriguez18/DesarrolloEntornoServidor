package com.example.MiPrimeraAplicacionSpringBoot.Controlador;

import com.example.MiPrimeraAplicacionSpringBoot.Modelos.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String userGreeting(
            @RequestParam(required = false) String name1,
            @RequestParam(required = false) String name2,
            Model model) {

        model.addAttribute("name1", name1);
        model.addAttribute("name2", name2);

        return "user-greeting";
    }

    @GetMapping("/helloworld")
    public String greeting(@RequestParam(required = false) String username, Model
            model) {
        model.addAttribute("message", "Hola " + username);
        return "greeting";
    }
}