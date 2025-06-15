package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.Catalogo;
import org.cibertec.soluciont2.entity.CatalogoValor;
import org.cibertec.soluciont2.service.CatalogoService;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private CatalogoValorService catalogoValorService;

    @GetMapping("/")
    public String mostrarMantenimiento(Model model) {
        model.addAttribute("catalogos", catalogoService.obtenerTodos());
        model.addAttribute("catalogoNuevo", new Catalogo());
        model.addAttribute("valorNuevo", new CatalogoValor());
        return "mantenimiento/catalogo"; // ✅ nueva vista centralizada
    }

    @PostMapping("/guardar")
    public String guardarCatalogo(@ModelAttribute("catalogoNuevo") Catalogo catalogo) {
        catalogoService.grabar(catalogo);
        return "redirect:/catalogo/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCatalogo(@PathVariable Integer id) {
        catalogoService.eliminar(id);
        return "redirect:/catalogo/";
    }

    @PostMapping("/valor/agregar")
    public String agregarValor(
            @ModelAttribute("valorNuevo") CatalogoValor valor,
            @RequestParam("catalogoId") Integer catalogoId
    ) {
        Catalogo catalogo = catalogoService.buscarPorID(catalogoId).orElseThrow();
        valor.setCatalogo(catalogo);
        catalogoValorService.grabar(valor);
        return "redirect:/catalogo/";
    }

    @GetMapping("/valor/eliminar/{id}")
    public String eliminarValor(@PathVariable Integer id) {
        CatalogoValor valor = catalogoValorService.buscarPorID(id).orElseThrow();
        Integer catalogoId = valor.getCatalogo().getId();
        catalogoValorService.eliminar(id);
        return "redirect:/catalogo/";
    }
}
