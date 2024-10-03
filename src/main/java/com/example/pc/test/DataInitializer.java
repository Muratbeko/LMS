//package com.example.pc.test;
//
//import com.example.pc.Models.Role;
//import com.example.pc.Models.User;
//import com.example.pc.Models.UserRole;
//import com.example.pc.repository.RoleRepository;
//import com.example.pc.repository.UserRepository;
//import com.example.pc.repository.UserRoleRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class DataInitializer {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//
//    @PostConstruct
//    public void init() {
//        Role adminRole = new Role("ADMIN");
//        Role userRole = new Role("USER");
//        Role directorRole = new Role("DIRECTOR");
//
//        roleRepository.save(adminRole);
//        roleRepository.save(userRole);
//        roleRepository.save(directorRole);
//
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword("{noop}admin"); // Для простоты, используйте "{noop}" для пропуска хэширования
//
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("{noop}user");
//
//        User director = new User();
//        director.setUsername("director");
//        director.setPassword("{noop}director");
//
//        userRepository.save(admin);
//        userRepository.save(user);
//        userRepository.save(director);
//
//        userRoleRepository.save(new UserRole(admin, adminRole));
//        userRoleRepository.save(new UserRole(admin, userRole));
//        userRoleRepository.save(new UserRole(user, userRole));
//        userRoleRepository.save(new UserRole(director, directorRole));
//    }
//}
