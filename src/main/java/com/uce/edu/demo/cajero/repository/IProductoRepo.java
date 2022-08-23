package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Producto;

public interface IProductoRepo {

    public Producto buscar(Integer id);
    public void actualizar(Producto prod);
    public void eliminar(Integer id);
    public void insertar(Producto prod);
    public Producto buscarCodigoBarras(String codigoBarras);
}
