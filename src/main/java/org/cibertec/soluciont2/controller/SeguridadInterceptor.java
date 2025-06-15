package org.cibertec.soluciont2.controller;
/*
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@ControllerAdvice
public class SeguridadInterceptor {

    @ModelAttribute
    public void verificarSesion(HttpSession session, HttpServletResponse response) throws IOException {
        String path = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
            .getRequest().getRequestURI();

        if (!path.startsWith("/login") && session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("/login");
        }
    }
}*/