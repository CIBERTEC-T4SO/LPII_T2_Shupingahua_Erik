package org.cibertec.soluciont2.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_catalogo_valor")
public class CatalogoValor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String valor;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_catalogo")
    private Catalogo catalogo;
}