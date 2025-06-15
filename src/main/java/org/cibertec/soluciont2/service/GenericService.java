package org.cibertec.soluciont2.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
     Optional<T> buscarPorID(ID id);
     List<T> obtenerTodos();
     void grabar(T entity);
     void eliminar(ID id);
}
