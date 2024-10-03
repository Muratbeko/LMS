package com.example.pc.Controllers;

import com.example.pc.Models.Role;
import com.example.pc.Models.User;
import com.example.pc.Models.UserRole;
import com.example.pc.Service.RoleService;
import com.example.pc.Service.UserService;
import com.example.pc.Service.UserRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // Create user role form
    @GetMapping("/admin/user-role/new")
    public String newUserRoleForm(Model model) {
        model.addAttribute("userRole", new UserRole());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("roles", roleService.findAllRoles());
        return "admin/user-role/create";
    }

    // Save new user role
    @PostMapping("/admin/user-role")
    public String createUserRole(@ModelAttribute("userRole") @Valid UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("roles", roleService.findAllRoles());
            return "admin/user-role/create";
        }

        userRoleService.saveUserRole(userRole);
        return "redirect:/admin/user-role";
    }

    // Display user role list
    @GetMapping("/admin/user-role")
    public String listUserRoles(Model model) {
        model.addAttribute("userRoles", userRoleService.findAllUserRoles());
        return "admin/user-role/list";
    }

    // Edit user role form
    @GetMapping("/admin/user-role/edit/{id}")
    public String editUserRoleForm(@PathVariable("id") Long id, Model model) {
        UserRole userRole = userRoleService.findById(id);
        if (userRole == null) {
            return "redirect:/admin/user-role";
        }
        model.addAttribute("userRole", userRole);
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("roles", roleService.findAllRoles());
        return "admin/user-role/edit";
    }

    // Update user role
    @PostMapping("/admin/user-role/{id}")
    public String updateUserRole(@PathVariable("id") Long id, @ModelAttribute("userRole") @Valid UserRole userRole, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("roles", roleService.findAllRoles());
            return "admin/user-role/edit";
        }

        userRole.setId(id);
        userRoleService.saveUserRole(userRole);
        return "redirect:/admin/user-role";
    }

    // Delete user role
    @GetMapping("/admin/user-role/delete/{id}")
    public String deleteUserRole(@PathVariable("id") Long id) {
        userRoleService.deleteUserRole(id);
        return "redirect:/admin/user-role";
    }
}
