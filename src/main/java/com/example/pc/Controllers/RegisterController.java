//package com.example.pc.Controllers;
//
//import com.example.pc.Models.User;
//import com.example.pc.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//@Controller
//public class RegisterController {
//
//    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
//
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user, @RequestParam("passwordConfirm") String passwordConfirm, Model model) {
//        if (userService.findByUsername(user.getUsername()) != null) {
//            model.addAttribute("error", "Username already exists!");
//            return "register";
//        }
//
//        if (!user.getPassword().equals(passwordConfirm)) {
//            model.addAttribute("error", "Passwords do not match");
//            return "register";
//        }
//
//        // Check password length and strength
//        if (user.getPassword().length() < 8) {
//            model.addAttribute("error", "Password must be at least 8 characters long");
//            return "register";
//        }
//
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userService.saveUser(user);
//
//        return "redirect:/login";
//    }
//}
