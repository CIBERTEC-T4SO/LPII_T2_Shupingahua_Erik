package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_catalogo")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String descripcion;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
    private List<CatalogoValor> valores;
}