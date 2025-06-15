package org.cibertec.soluciont2.entity.security;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "seg_perfil")
@Entity
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccesoEntity> accesos;
}