package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.security.UsuarioEntity;
import org.cibertec.soluciont2.repository.UsuarioRepository;
import org.cibertec.soluciont2.repository.UsuarioRepository;
import org.cibertec.soluciont2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }

    @Override
    public Optional<UsuarioEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<UsuarioEntity> validarLogin(String username, String password) {
        return repository.validarLogin(username, password);
    }
}
