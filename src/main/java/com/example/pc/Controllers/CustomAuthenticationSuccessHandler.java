package com.example.pc.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        try {
            String username = authentication.getName();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            System.out.println("Authenticated user: " + username);
            System.out.println("Roles: " + authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(", ")));

            // Redirect based on roles
            if (authorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN"))) {
                response.sendRedirect("/admin/home");
            } else if (authorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("USER"))) {
                response.sendRedirect("/user/home2");
            } else if (authorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("Mentor"))) {
                response.sendRedirect("/director/home3");
            } else {
                response.sendRedirect("/home4");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            response.sendRedirect("/error"); // Redirect to an error page
        }
    }
}
