package com.example.pc.Security;

import com.example.pc.Controllers.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .requestMatchers("/user/**").hasAuthority("USER")
                                .requestMatchers("/director/**").hasAuthority("Mentor")
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/admin/home", "/user/home2", "/director/home3").permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .successHandler(customAuthenticationSuccessHandler())
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );

        return http.build();
    }

    @Bean(name = "customAuthSuccessHandler")
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
