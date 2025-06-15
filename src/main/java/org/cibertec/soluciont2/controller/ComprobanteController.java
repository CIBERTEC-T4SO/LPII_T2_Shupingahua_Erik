package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.ComprobanteEntity;
import org.cibertec.soluciont2.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("lista", comprobanteService.obtenerTodos());
        model.addAttribute("comprobante", new ComprobanteEntity());
        return "comprobante";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ComprobanteEntity comprobante) {
        comprobanteService.grabar(comprobante);
        return "redirect:/comprobante/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("lista", comprobanteService.obtenerTodos());
        model.addAttribute("comprobante", comprobanteService.buscarPorID(id));
        return "comprobante";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        comprobanteService.eliminar(id);
        return "redirect:/comprobante/";
    }
}
