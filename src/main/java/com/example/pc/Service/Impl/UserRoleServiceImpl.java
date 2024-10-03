package com.example.pc.Service.Impl;

import com.example.pc.Models.UserRole;
import com.example.pc.Service.UserRoleService;
import com.example.pc.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public UserRole findById(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
