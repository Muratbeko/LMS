//package com.example.pc.test;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@Profile("test")
//public class TestSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .anyRequest().permitAll()
//                )
//                .csrf().disable(); // Отключение CSRF для тестирования
//
//        return http.build();
//    }
//}
//
