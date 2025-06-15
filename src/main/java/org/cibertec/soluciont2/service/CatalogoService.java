package org.cibertec.soluciont2.service;

import org.cibertec.soluciont2.entity.Catalogo;

import java.util.Optional;

public interface CatalogoService extends GenericService<Catalogo, Integer> {

  Optional<Catalogo> obtenerPorCodigo(String codigo);
}