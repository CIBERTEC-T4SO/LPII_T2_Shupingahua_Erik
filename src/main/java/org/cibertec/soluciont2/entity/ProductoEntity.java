package org.cibertec.soluciont2.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tb_producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Integer stock;
    private Double precio;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private CatalogoValor categoria;


    //-Relación opcional con proveedor
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_proveedor", nullable = true)
    private ProveedorEntity proveedor;



}