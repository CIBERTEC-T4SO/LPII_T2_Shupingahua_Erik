package org.cibertec.soluciont2.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_pago")
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double monto;
    private Date fechapago;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "metodo") // catálogo: Efectivo, Tarjeta, etc.
    private CatalogoValor metodoPago;

    @ManyToOne
    @JoinColumn(name = "estado") // catálogo: Pagado, Pendiente, Fallido
    private CatalogoValor estadoPago;

    private String referencia; // número de operación, voucher, etc.
}