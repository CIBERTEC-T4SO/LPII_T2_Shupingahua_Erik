package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.ProveedorEntity;
import org.cibertec.soluciont2.service.CountryService;
import org.cibertec.soluciont2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private CountryService paisService;


    @GetMapping("/inicio")
    String paginaprincipal(Model model) {
        ProveedorEntity proveedor= new ProveedorEntity();// id=null
        model.addAttribute("lista",proveedorService.getAll());
        model.addAttribute("paises",paisService.getAll());
        model.addAttribute("proveedor",proveedor);
        return "proveedores";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute ProveedorEntity proveedor) {
        proveedorService.create(proveedor);
        return "redirect:/proveedor/inicio";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam("id") Integer id, Model model) {
        ProveedorEntity proveedor = proveedorService.getById(id); //ID:1,2,3,4
        model.addAttribute("lista",proveedorService.getAll());
        model.addAttribute("paises",paisService.getAll());
        model.addAttribute("proveedor",proveedor);
        return "proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Integer id) {
        proveedorService.remove(id);
        return "redirect:/proveedor/inicio";
    }
/*
    @DeleteMapping("/eliminar/{id}")
    public String eliminarProveedorDel(@PathVariable Integer id) {
        proveedorService.remove(id);
        return "redirect:/proveedor/inicio";
    }*/
}
