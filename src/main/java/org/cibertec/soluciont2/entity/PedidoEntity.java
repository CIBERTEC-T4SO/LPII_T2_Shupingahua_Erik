package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.cibertec.soluciont2.entity.security.UsuarioEntity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;
    private String canal;

    @ManyToOne
    @JoinColumn(name = "cod_usua")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private PersonaEntity cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private PagoEntity pago;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalleEntity> detalles;
}