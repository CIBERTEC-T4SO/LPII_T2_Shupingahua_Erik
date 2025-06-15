package org.cibertec.soluciont2.service;

import org.cibertec.soluciont2.entity.security.UsuarioEntity;

import java.util.Optional;

public interface UsuarioService extends org.cibertec.soluciont2.service.GenericService<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);
    Optional<UsuarioEntity> validarLogin(String username, String password);

}
