package com.example.pc.Controllers;

import com.example.pc.Models.Role;
import com.example.pc.Service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public String listRoles(Model model) {
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        return "admin/roles/list";
    }

    @GetMapping("/new")
    public String createRoleForm(Model model) {
        model.addAttribute("role", new Role());
        return "admin/roles/create";
    }

    @PostMapping
    public String saveRole(@ModelAttribute("role") Role role, Model model) {
        System.out.println("Role: " + role); // Логирование для отладки
        roleService.saveRole(role);
        return "redirect:/admin/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable Long id, Model model) {
        Role role = roleService.findById(id);
        if (role == null) {
            return "redirect:admin/roles";
        }
        model.addAttribute("role", role);
        return "admin/roles/edit";
    }

    @PostMapping("/{id}")
    public String updateRole(@PathVariable Long id, @ModelAttribute("role") Role role) {
        role.setId(id);
        roleService.updateRole(role);
        return "redirect:/admin/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/admin/roles";
    }
}
