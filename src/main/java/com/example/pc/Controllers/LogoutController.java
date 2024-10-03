package com.example.pc.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Очистите сессии и любые другие данные авторизации здесь
        request.getSession().invalidate();
        // Можно добавить логику, чтобы удалить кук или очистить другие данные
        return "redirect:/login"; // Перенаправление на страницу входа
    }
}
