package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.security.AccesoEntity;
import org.cibertec.soluciont2.service.AccesoService;
import org.cibertec.soluciont2.service.PerfilService;
import org.cibertec.soluciont2.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accesos")
public class AccesoController {

    @Autowired
    private AccesoService accesoService;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("accesos", accesoService.obtenerTodos());
        model.addAttribute("acceso", new AccesoEntity());
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("roles", rolService.obtenerTodos());
        return "security/accesos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute AccesoEntity acceso) {
        accesoService.grabar(acceso);
        return "redirect:/accesos/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("accesos", accesoService.obtenerTodos());
        model.addAttribute("acceso", accesoService.buscarPorID(id));
        model.addAttribute("perfiles", perfilService.obtenerTodos());
        model.addAttribute("roles", rolService.obtenerTodos());
        return "security/accesos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        accesoService.eliminar(id);
        return "redirect:/accesos/";
    }
}
