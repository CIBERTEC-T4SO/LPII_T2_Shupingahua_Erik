package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.ProductoEntity;
import org.cibertec.soluciont2.repository.ProductoRepository;
import org.cibertec.soluciont2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<ProductoEntity, Integer> implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
