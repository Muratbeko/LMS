package com.example.pc.Service;

import com.example.pc.Models.UserRole;
import java.util.List;

public interface UserRoleService {
    void saveUserRole(UserRole userRole);
    UserRole findById(Long id);
    List<UserRole> findAllUserRoles();
    void deleteUserRole(Long id);
}
