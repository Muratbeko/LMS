package com.example.pc.Controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
    @GetMapping("/")
    public RedirectView redirectToLogin() {
        return new RedirectView("/login");
    }
    @Secured("ROLE_USER")
    @GetMapping("/user/home2")
    public String home2(Model model) {
        // Логика для страницы пользователя
        return "user/home2"; // Убедитесь, что это имя файла Thymeleaf шаблона
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/home")
    public String home(Model model) {
        // Логика для страницы администратора
        return "admin/home"; // Убедитесь, что это имя файла Thymeleaf шаблона
    }

    @GetMapping("/director/home3")
    public String home3(Model model) {
        // Логика для страницы, если роль не ADMIN и не USER
        return "/director/home3"; // Убедитесь, что это имя файла Thymeleaf шаблона
    }
    @GetMapping("/director/home4")
    public String home4(Model model) {
        // Логика для страницы, если роль не ADMIN и не USER
        return "director/home4"; // Убедитесь, что это имя файла Thymeleaf шаблона
    }
}
