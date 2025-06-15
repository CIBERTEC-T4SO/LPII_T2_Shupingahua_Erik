package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_comprobante")
public class ComprobanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private CatalogoValor tipo;

    private String serie;
    private String numero;
    private LocalDateTime fechaEmision;
    @ManyToOne
    @JoinColumn(name = "infor_emisor")
    private Catalogo info_emisor;
}