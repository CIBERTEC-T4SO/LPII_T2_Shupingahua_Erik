package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.ComprobanteEntity;
import org.cibertec.soluciont2.repository.ComprobanteRepository;
import org.cibertec.soluciont2.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends GenericServiceImpl<ComprobanteEntity, Long> implements ComprobanteService {

    @Autowired
    private ComprobanteRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
