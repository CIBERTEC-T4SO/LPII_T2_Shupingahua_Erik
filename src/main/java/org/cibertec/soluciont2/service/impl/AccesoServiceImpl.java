package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.security.AccesoEntity;
import org.cibertec.soluciont2.repository.AccesoRepository;
import org.cibertec.soluciont2.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoServiceImpl extends GenericServiceImpl<AccesoEntity, Long> implements AccesoService {

    @Autowired
    private AccesoRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
