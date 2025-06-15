package org.cibertec.soluciont2.entity.security;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "seg_acceso")
@Entity
public class AccesoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol;
}