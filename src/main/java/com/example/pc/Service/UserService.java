package com.example.pc.Service;

import com.example.pc.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.pc.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findByUsername(String username);
    User findById(Long id);
    List<User> findAllUsers();
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
