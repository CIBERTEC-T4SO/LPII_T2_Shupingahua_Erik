package org.cibertec.soluciont2.service;

import org.cibertec.soluciont2.entity.PedidoEntity;

public interface PedidoService extends GenericService<PedidoEntity, Integer> {
    public void grabarPedidoCompleto(PedidoEntity pedido)  ;
}