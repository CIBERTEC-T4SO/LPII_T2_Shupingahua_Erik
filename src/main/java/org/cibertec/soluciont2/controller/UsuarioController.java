package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.security.UsuarioEntity;
import org.cibertec.soluciont2.service.PersonaService;
import org.cibertec.soluciont2.service.PerfilService;
import org.cibertec.soluciont2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("personas", personaService.obtenerTodos());
        return "security/usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute UsuarioEntity usuario) {
        usuarioService.grabar(usuario);
        return "redirect:/usuarios/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        model.addAttribute("usuario", usuarioService.buscarPorID(id));
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("personas", personaService.obtenerTodos());
        return "security/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios/";
    }
}
