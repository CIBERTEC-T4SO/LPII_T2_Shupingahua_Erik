package org.cibertec.soluciont2.controller;

import org.cibertec.soluciont2.entity.CatalogoValor;
import org.cibertec.soluciont2.entity.PedidoDetalleEntity;
import org.cibertec.soluciont2.entity.PedidoEntity;
import org.cibertec.soluciont2.entity.ProductoEntity;
import org.cibertec.soluciont2.service.CatalogoService;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.cibertec.soluciont2.service.PedidoService;
import org.cibertec.soluciont2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
/*
@Controller
@RequestMapping("/store")
@SessionAttributes("pedidoActual")
public class PedidoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @ModelAttribute("pedidoActual")
    public PedidoEntity initPedido() {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setDetalles(new ArrayList<>());
        return pedido;
    }

    @GetMapping("")
    public String mostrarFormulario(Model model, @ModelAttribute("pedidoActual") PedidoEntity pedido) {
        model.addAttribute("productos", productoService.obtenerTodos());
        model.addAttribute("detalleNuevo", new PedidoDetalleEntity());
        return "store/pedido";
    }

    @PostMapping("/agregar-producto")
    public String agregarProducto(@ModelAttribute("detalleNuevo") PedidoDetalleEntity detalle,
                                  @RequestParam("productoId") Integer productoId,
                                  @ModelAttribute("pedidoActual") PedidoEntity pedido) {

        ProductoEntity producto = productoService.buscarPorID(productoId).orElseThrow();
        detalle.setProducto(producto);
        detalle.setPrecio(producto.getPrecio());
        detalle.setPedido(pedido);

        pedido.getDetalles().add(detalle);
        return "redirect:/store";
    }

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute("pedidoActual") PedidoEntity pedido,
                                SessionStatus status) {
        pedidoService.grabarPedidoCompleto(pedido); // método transaccional
        status.setComplete(); // limpia la sesión
        return "redirect:/store?success";
    }

    @GetMapping("/remover/{index}")
    public String removerDetalle(@PathVariable int index,
                                 @ModelAttribute("pedidoActual") PedidoEntity pedido) {
        pedido.getDetalles().remove(index);
        return "redirect:/store";
    }
}*/
