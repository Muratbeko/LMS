//package com.example.pc.test;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class PasswordTest {
//    public static void main(String[] args) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        String rawPassword = "mySecretPassword";
//        String encodedPassword = encoder.encode(rawPassword);
//
//        // Выводим закодированный пароль
//        System.out.println("Encoded Password: " + encodedPassword);
//
//        // Проверяем правильность пароля
//        boolean isMatch = encoder.matches(rawPassword, encodedPassword);
//        System.out.println("Password match: " + isMatch);
//
//        // Проверяем неправильный пароль
//        boolean isMatchWrongPassword = encoder.matches("wrongPassword", encodedPassword);
//        System.out.println("Wrong password match: " + isMatchWrongPassword);
//    }
//}
