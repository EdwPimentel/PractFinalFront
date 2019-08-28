package com.regedw.PractFinalFront.servicios;

import com.regedw.PractFinalFront.Producto;
import com.regedw.PractFinalFront.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicios {

    @Autowired
    private ProductoRepositorio productoRepositorio;


    public void crearProducto(Producto producto){
        productoRepositorio.save(producto);
    }

    public Producto buscarProductoPorId(int id){

        return productoRepositorio.findProductoById(id);
    }




    public List<Producto> ListarProductos(){
        return productoRepositorio.findAll();
    }




    public void eliminarProducto(Producto producto){


        productoRepositorio.delete(producto);


    }
}
