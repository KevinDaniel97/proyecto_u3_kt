package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Producto;

public interface IProductoRepo {

    public Producto buscar(String codigo);
    public void actualizar(Producto producto);

}
