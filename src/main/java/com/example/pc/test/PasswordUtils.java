//package com.example.pc.test;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class PasswordUtils {
//
//    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    // Метод для хэширования пароля
//    public static String hashPassword(String rawPassword) {
//        return encoder.encode(rawPassword);
//    }
//
//    // Метод для проверки пароля
//    public static boolean checkPassword(String rawPassword, String encodedPassword) {
//        return encoder.matches(rawPassword, encodedPassword);
//    }
//
//    public static void main(String[] args) {
//        String rawPassword = "mySecretPassword";
//        String encodedPassword = hashPassword(rawPassword);
//
//        System.out.println("Encoded Password: " + encodedPassword);
//
//        // Проверка правильности пароля
//        boolean isMatch = checkPassword(rawPassword, encodedPassword);
//        System.out.println("Password match: " + isMatch);
//    }
//}
