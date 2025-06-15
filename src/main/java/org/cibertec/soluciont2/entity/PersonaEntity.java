package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    private String nombres_razonsocial;
    private String apellidos;
    @ManyToOne
    @JoinColumn(name = "tipo_doc")
    private CatalogoValor tipo_documento;

    private String numeroDocumento;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String genero;
}