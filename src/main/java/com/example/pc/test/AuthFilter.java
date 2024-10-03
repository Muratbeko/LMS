package com.example.pc.test;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();
        String[] restrictedPages = {"/admin", "/transaction"}; // Укажите страницы, которые требуют авторизации

        boolean isRestricted = false;
        for (String page : restrictedPages) {
            if (requestURI.startsWith(page)) {
                isRestricted = true;
                break;
            }
        }

        if (isRestricted && (session == null || session.getAttribute("user") == null)) {
            httpResponse.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
