//package com.example.pc.Controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public String loginPage(Model model) {
//        return "login";
//    }
//
//    @GetMapping("/home")
//    public String homePage(Model model) {
//        // Обработка ошибки, если она присутствует
//        if (model.containsAttribute("error")) {
//            model.addAttribute("error", "Ошибка входа. Пожалуйста, попробуйте снова.");
//        }
//        return "home"; // Убедитесь, что у вас есть представление home.html
//    }
//}
