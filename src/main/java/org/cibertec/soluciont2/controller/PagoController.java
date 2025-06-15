package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.PagoEntity;
import org.cibertec.soluciont2.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("lista", pagoService.obtenerTodos());
        model.addAttribute("pago", new PagoEntity());
        return "pago";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PagoEntity pago) {
        pagoService.grabar(pago);
        return "redirect:/pago/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("lista", pagoService.obtenerTodos());
        model.addAttribute("pago", pagoService.buscarPorID(id));
        return "pago";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return "redirect:/pago/";
    }
}
