package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.PersonaEntity;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.cibertec.soluciont2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CatalogoValorService catalogoValorService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("lista", personaService.obtenerTodos());
        model.addAttribute("persona", new PersonaEntity());
        model.addAttribute("tiposDoc", catalogoValorService.obtenerTodos());
        return "persona";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PersonaEntity persona) {
        personaService.grabar(persona);
        return "redirect:/persona/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("lista", personaService.obtenerTodos());
        model.addAttribute("persona", personaService.buscarPorID(id));
        model.addAttribute("tiposDoc", catalogoValorService.obtenerTodos());
        return "persona";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        personaService.eliminar(id);
        return "redirect:/persona/";
    }
}
