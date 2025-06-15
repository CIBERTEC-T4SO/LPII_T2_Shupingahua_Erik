package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.ProveedorEntity;
import org.cibertec.soluciont2.repository.ProveedorRepository;
import org.cibertec.soluciont2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<ProveedorEntity, Integer> implements ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
