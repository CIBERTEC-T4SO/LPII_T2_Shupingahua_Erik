package org.cibertec.soluciont2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PedidoDetalleReporteDto {

    private Integer id;
    private Integer cantidad;
    private Double descuento;
    private Double precio;
    private Integer id_pedido;
    private Integer id_prod;
    private String canal;
    private java.util.Date fecha;
    private String cod_usua;
    private String cod_cliente;
    private Integer idPersona;
    private String apellidos;
    private String direccion;
    private java.util.Date fechaNacimiento;
    private String genero;
    private String nombres_razonsocial;
    private String numeroDocumento;
    private String telefono;
    private String tipo_doc;
    private String descripcion;
    private String estado;
    private Integer stock;
    private String categoria;
    private Integer id_proveedor;
    private double cal_total;
    public PedidoDetalleReporteDto(double cal_total, Date fecha,  String nombres_razonsocial, String numeroDocumento, Integer id, Integer id_prod, String descripcion, Double precio, Integer cantidad) {
        this.fecha= fecha;
        this.cal_total=cal_total;
        this.nombres_razonsocial=nombres_razonsocial;
        this.numeroDocumento=numeroDocumento;
        this.id = id;
        this.id_prod = id_prod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}