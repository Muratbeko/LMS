package com.example.pc.Service;

import com.example.pc.Models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAllRoles();
    void saveRole(Role role);
    Role findById(Long id);
    Role updateRole(Role role);
    void deleteRole(Long id);
    Role findByRoleName(String roleName);
}
