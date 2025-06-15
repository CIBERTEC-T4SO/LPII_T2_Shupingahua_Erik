package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "provider")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "doc_number")
    private String doc;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "hash")
    private String hash;


    @ManyToOne
    @JoinColumn(name = "idpais")
    private CountryEntity pais;


}