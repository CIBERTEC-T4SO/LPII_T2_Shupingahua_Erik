package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.security.PerfilEntity;
import org.cibertec.soluciont2.repository.PerfilRepository;
import org.cibertec.soluciont2.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl extends GenericServiceImpl<PerfilEntity, Long> implements PerfilService {

    @Autowired
    private PerfilRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
