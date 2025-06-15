package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.security.RolEntity;
import org.cibertec.soluciont2.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("roles", rolService.obtenerTodos());
        model.addAttribute("rol", new RolEntity());
        return "security/roles";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute RolEntity rol) {
        rolService.grabar(rol);
        return "redirect:/roles/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("roles", rolService.obtenerTodos());
        model.addAttribute("rol", rolService.buscarPorID(id));
        return "security/roles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/roles/";
    }
}
