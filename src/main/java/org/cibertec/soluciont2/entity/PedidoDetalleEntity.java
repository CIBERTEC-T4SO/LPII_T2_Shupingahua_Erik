package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pedido_detalle")
public class PedidoDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    private Double precio;
    private Double descuento;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "id_prod")
    private ProductoEntity producto;
}