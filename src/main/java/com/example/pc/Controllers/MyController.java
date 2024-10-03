package com.example.pc.Controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MyController {
    @Secured("ROLE_ADMIN")
    @GetMapping("/adminPage")
    public String adminPage(Model model) {
        // Логика для страницы администратора
        return "home";
    }

    @Secured("ROLE_USER")
    @GetMapping("/userPage")
    public String userPage(Model model) {
        // Логика для страницы пользователя
        return "home2";
    }


    @GetMapping("/publicPage")
    public String publicPage(Model model) {
        // Логика для публичной страницы
        return "access-denied";
    }
}
