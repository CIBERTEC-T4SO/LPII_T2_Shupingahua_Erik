package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.PagoEntity;
import org.cibertec.soluciont2.repository.PagoRepository;
import org.cibertec.soluciont2.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends GenericServiceImpl<PagoEntity, Long> implements PagoService {

    @Autowired
    private PagoRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
