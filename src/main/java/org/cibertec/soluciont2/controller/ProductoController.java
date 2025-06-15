package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.ProductoEntity;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.cibertec.soluciont2.service.ProductoService;
import org.cibertec.soluciont2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CatalogoValorService catalogoValorService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("lista", productoService.obtenerTodos());
        model.addAttribute("producto", new ProductoEntity());
        model.addAttribute("categorias", catalogoValorService.obtenerTodos());
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "producto";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ProductoEntity producto) {
        productoService.grabar(producto);
        return "redirect:/producto/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("lista", productoService.obtenerTodos());
        model.addAttribute("producto", productoService.buscarPorID(id));
        model.addAttribute("categorias", catalogoValorService.obtenerTodos());
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "producto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "redirect:/producto/";
    }
}
