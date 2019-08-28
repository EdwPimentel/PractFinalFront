package com.regedw.PractFinalFront.repositorios;

import com.regedw.PractFinalFront.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepositorio extends JpaRepository<Compras, Integer> {

    Compras findCompraById(int id);
}
