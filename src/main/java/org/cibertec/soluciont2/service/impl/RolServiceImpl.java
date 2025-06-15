package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.security.RolEntity;
import org.cibertec.soluciont2.repository.RolRepository;
import org.cibertec.soluciont2.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<RolEntity, Long> implements RolService {

    @Autowired
    private RolRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
