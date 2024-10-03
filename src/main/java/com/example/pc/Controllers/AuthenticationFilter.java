//package com.example.pc.Controllers;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//public class AuthenticationFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Инициализация фильтра (можно оставить пустым)
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // Проверяем, есть ли активная сессия
//        if (httpRequest.getSession().getAttribute("user") == null) {
//            // Если нет активной сессии, перенаправляем на страницу входа
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
//            return;
//        }
//
//        // Если сессия активна, пропускаем запрос дальше
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // Очистка ресурсов (можно оставить пустым)
//    }
//}
