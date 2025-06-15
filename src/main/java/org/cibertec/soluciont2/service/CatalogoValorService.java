package org.cibertec.soluciont2.service;

import org.cibertec.soluciont2.entity.Catalogo;
import org.cibertec.soluciont2.entity.CatalogoValor;

import java.util.Optional;

public interface CatalogoValorService extends GenericService<CatalogoValor, Integer> {

  Optional<CatalogoValor> obtenerPorCodigo(String codigo);
}