package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.PedidoDetalleEntity;
import org.cibertec.soluciont2.repository.PedidoDetalleRepository;
import org.cibertec.soluciont2.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalleServiceImpl extends GenericServiceImpl<PedidoDetalleEntity, Integer> implements PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
