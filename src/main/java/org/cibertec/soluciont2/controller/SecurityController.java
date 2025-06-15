package org.cibertec.soluciont2.controller;
/*
import jakarta.servlet.http.HttpSession;
import org.cibertec.soluciont2.entity.security.UsuarioEntity;
import org.cibertec.soluciont2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SecurityController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "security/login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        return usuarioService.validarLogin(email, password)
                .map(usuario -> {
                    session.setAttribute("usuarioLogueado", usuario);
                    session.setAttribute("accesos", usuario.getPerfil().getAccesos());
                    System.out.println("Usuario logueado: " + usuario.getUsername());
                    return "redirect:/home";
                })
                .orElseGet(() -> {
                    System.out.println("Usuario no encontrado");
                    model.addAttribute("error", "Usuario o contraseña incorrectos");
                    return "security/login";
                });
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}*/
