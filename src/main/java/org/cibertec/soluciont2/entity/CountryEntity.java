package org.cibertec.soluciont2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}