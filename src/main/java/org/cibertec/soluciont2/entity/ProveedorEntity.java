package org.cibertec.soluciont2.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_provider")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String telefono;
    private String email;

    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private PersonaEntity persona;

    @OneToMany(mappedBy = "proveedor")
    private List<ProductoEntity> productos;

}