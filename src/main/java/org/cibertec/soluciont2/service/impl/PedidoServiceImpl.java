package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cibertec.soluciont2.entity.PedidoDetalleEntity;
import org.cibertec.soluciont2.entity.PedidoEntity;
import org.cibertec.soluciont2.repository.PedidoDetalleRepository;
import org.cibertec.soluciont2.repository.PedidoRepository;
import org.cibertec.soluciont2.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<PedidoEntity, Integer> implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }


    @Transactional
    @Override
    public void grabarPedidoCompleto(PedidoEntity pedido) {
        // Guardar el pedido primero (genera el ID)
        pedido.setCanal("WEB");
        pedido.setFecha(new Date(System.currentTimeMillis()));
        repository.save(pedido);

        // Asociar y guardar los detalles
        for (PedidoDetalleEntity detalle : pedido.getDetalles()) {
            detalle.setPedido(pedido);
            pedidoDetalleRepository.save(detalle);
        }
    }

}