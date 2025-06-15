package org.cibertec.soluciont2.entity.security;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "seg_rol")
@Entity
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ruta;
    private String icono;
    private String css;
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<AccesoEntity> accesos;
}