package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
}
