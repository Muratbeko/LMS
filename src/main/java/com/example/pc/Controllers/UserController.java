package com.example.pc.Controllers;

import com.example.pc.Models.User;
import com.example.pc.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        User user = userService.findByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

        session.setAttribute("user", user);
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result, @RequestParam("passwordConfirm") String passwordConfirm, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }

        if (!user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        if (user.getPassword().length() < 8) {
            model.addAttribute("error", "Password must be at least 8 characters long");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        return "redirect:/login";
    }
    @GetMapping("/user/about")
    public String about() {
        return "user/about"; // Убедитесь, что этот файл существует по пути src/main/resources/templates/user/about.html
    }

    // Метод для отображения страницы "Контакты"
    @GetMapping("/user/contact")
    public String contact() {
        return "user/contact"; // Убедитесь, что этот файл существует по пути src/main/resources/templates/user/contact.html
    }
        // Create user form
    @GetMapping("/admin/user/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/user/create";
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "admin/user/create";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin/user/list";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/admin/user";
        }
        model.addAttribute("user", user);
        return "admin/user/edit";
    }


    @PostMapping("/admin/user/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/user/edit";
        }

        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }
}
