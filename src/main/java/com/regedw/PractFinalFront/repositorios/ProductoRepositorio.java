package com.regedw.PractFinalFront.repositorios;

import com.regedw.PractFinalFront.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

    Producto findProductoById (int id);
}
