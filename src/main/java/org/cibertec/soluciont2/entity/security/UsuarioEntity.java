package org.cibertec.soluciont2.entity.security;
import jakarta.persistence.*;
import lombok.Data;
import org.cibertec.soluciont2.entity.PersonaEntity;

@Data
@Table(name = "seg_usuario")
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaEntity persona;




}