package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.security.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    @Query("SELECT u FROM UsuarioEntity u WHERE u.username = :email AND u.password = :password")
    Optional<UsuarioEntity>  validarLogin(@Param("email") String email, @Param("password") String password);


    Optional<UsuarioEntity> findByUsername(String username);
}
