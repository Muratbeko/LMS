package com.example.pc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String home(Model model) {
        model.addAttribute("Title", "Main page");
        return "blog-main";
    }
}
