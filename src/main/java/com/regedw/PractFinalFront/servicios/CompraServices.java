package com.regedw.PractFinalFront.servicios;
import com.regedw.PractFinalFront.Compras;
import com.regedw.PractFinalFront.Producto;
import com.regedw.PractFinalFront.repositorios.CompraRepositorio;
import com.regedw.PractFinalFront.repositorios.ProductoRepositorio;
import com.regedw.PractFinalFront.repositorios.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {

    @Autowired
    CompraRepositorio compraRepository;

    public void crearCompra(Compras compra) {
        compraRepository.save(compra);
    }

    public Compras devolverNuevaCompra(Compras compra) {
        return compraRepository.save(compra);
    }

    public List<Compras> buscarTodos() {
        return compraRepository.findAll();
    }

    public Compras buscarPorId(Long id) {
        return compraRepository.findCompraById(id);
    }

}
