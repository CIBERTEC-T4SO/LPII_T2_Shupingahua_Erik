package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.security.PerfilEntity;
import org.cibertec.soluciont2.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("perfil", new PerfilEntity());
        return "security/perfiles";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PerfilEntity perfil) {
        perfilService.grabar(perfil);
        return "redirect:/perfiles/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("perfil", perfilService.buscarPorID(id));
        return "security/perfiles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        perfilService.eliminar(id);
        return "redirect:/perfiles/";
    }
}
