package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.CatalogoValor;
import org.cibertec.soluciont2.service.CatalogoService;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catalogovalor")
public class CatalogoValorController {

    @Autowired
    private CatalogoValorService catalogoValorService;

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("lista", catalogoValorService.obtenerTodos());
        model.addAttribute("catalogos", catalogoService.obtenerTodos());
        model.addAttribute("catalogovalor", new CatalogoValor());
        return "catalogovalor";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute CatalogoValor catalogoValor) {
        catalogoValorService.grabar(catalogoValor);
        return "redirect:/catalogovalor/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("lista", catalogoValorService.obtenerTodos());
        model.addAttribute("catalogos", catalogoService.obtenerTodos());
        model.addAttribute("catalogovalor", catalogoValorService.buscarPorID(id));
        return "catalogovalor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        catalogoValorService.eliminar(id);
        return "redirect:/catalogovalor/";
    }
}
