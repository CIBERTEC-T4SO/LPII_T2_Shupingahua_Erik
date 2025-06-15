package org.cibertec.soluciont2.controller;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.cibertec.soluciont2.entity.*;
import org.cibertec.soluciont2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/store")
@SessionAttributes("pedidoWizard")
public class StoreWizardController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @ModelAttribute("pedidoWizard")
    public PedidoEntity pedidoWizard() {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setFecha(new Date(System.currentTimeMillis()));
        pedido.setDetalles(new ArrayList<>());
        return pedido;
    }

    // Paso 1: seleccionar cliente
    @GetMapping("/cliente")
    public String paso1Cliente(Model model) {
        model.addAttribute("clientes", personaService.obtenerTodos());
        return "store/paso1_cliente";
    }

    @PostMapping("/cliente")
    public String seleccionarCliente(@RequestParam("clienteId") Integer idCliente,
                                     @ModelAttribute("pedidoWizard") PedidoEntity pedido) {
        PersonaEntity cliente = personaService.buscarPorID (idCliente).orElseThrow();
        pedido.setCliente(cliente);
        return "redirect:/store/productos";
    }

    // Paso 2: seleccionar productos
    @GetMapping("/productos")
    public String paso2Productos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodos());
        return "store/paso2_productos";
    }

    @PostMapping("/productos")
    public String agregarProducto(@RequestParam("productoId") Integer idProducto,
                                  @RequestParam("cantidad") Integer cantidad,
                                  @ModelAttribute("pedidoWizard") PedidoEntity pedido) {
        ProductoEntity producto = productoService.buscarPorID(idProducto).orElseThrow();
        PedidoDetalleEntity detalle = new PedidoDetalleEntity();
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecio(producto.getPrecio());
        detalle.setPedido(pedido);
        pedido.getDetalles().add(detalle);
        return "redirect:/store/productos";
    }

    @GetMapping("/eliminar-producto/{index}")
    public String eliminarProducto(@PathVariable("index") int index,
                                   @ModelAttribute("pedidoWizard") PedidoEntity pedido) {
        pedido.getDetalles().remove(index);
        return "redirect:/store/productos";
    }
/*
    // Paso 3: Confirmar pedido
    @GetMapping("/confirmar")
    public String paso3Resumen() {

        return "store/paso3_resumen";
    }*/
@GetMapping("/confirmar")
public String paso3Resumen(HttpSession session, Model model) {
    PedidoEntity pedido = (PedidoEntity) session.getAttribute("pedidoWizard");

    if (pedido == null || pedido.getCliente() == null || pedido.getDetalles() == null) {
        return "redirect:/store"; // o paso 1 si está incompleto
    }

    // (Opcional) Calcular total
    double total = pedido.getDetalles().stream()
            .mapToDouble(d -> (d.getPrecio()  ) * d.getCantidad())
            .sum();
    model.addAttribute("total", total);

    model.addAttribute("pedido", pedido);
    return "store/paso3_resumen";
}


    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute("pedidoWizard") PedidoEntity pedido, SessionStatus status) {
        pedidoService.grabarPedidoCompleto(pedido);
        //
        //
        // status.setComplete();
        return "redirect:/store/confirmar"; //cliente?success";
    }

    @GetMapping("/pedido/pdf/{id}")
    public void generarPDF(@PathVariable("id") Integer id, HttpServletResponse response) throws Exception {
        PedidoEntity pedido = pedidoService.buscarPorID(id).get();

        InputStream jasperStream = getClass().getResourceAsStream("/reportej.jasper");
/*
        Map<String, Object> params = new HashMap<>();
        params.put("fecha", pedido.getFecha());
        params.put("total", pedido.getDetalles().stream()
                .mapToDouble(d -> d.getPrecio() * d.getCantidad())
                .sum());*/

        List<PedidoDetalleReporteDto> detallesDto = pedido.getDetalles().stream()
                .map(det -> new PedidoDetalleReporteDto(
                        pedido.getDetalles().stream()
                                .mapToDouble(d -> d.getPrecio() * d.getCantidad())
                                .sum(),
                        pedido.getFecha(),
                        pedido.getCliente().getNombres_razonsocial(),
                        pedido.getCliente().getNumeroDocumento(),
                        det.getProducto().getId(),
                        det.getProducto().getId(),
                        det.getProducto().getDescripcion(),
                        det.getPrecio(),
                        det.getCantidad()
                ))
                .collect(Collectors.toList());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(detallesDto);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, dataSource);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=pedido_" + id + ".pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }


   /* @Autowired
    private ResourceLoader resourceLoader; // core.io
    @GetMapping("/reportes")
    public void reportes(HttpServletResponse response) {
        // opción 1
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
        // opción 2
        response.setHeader("Content-Disposition", "inline;");

        response.setContentType("application/pdf");
        try {
            String ru = resourceLoader.getResource("classpath:reporte.jasper").getURI().getPath();
            JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
            OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
