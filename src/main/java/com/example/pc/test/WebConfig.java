package com.example.pc.test;


import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**", "/images/**");
    }
//    @Bean
//    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter() {
//        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new AuthenticationFilter());
//        registrationBean.addUrlPatterns("/*"); // Применяется ко всем URL
//        return registrationBean;
//    }
}
