package com.uce.edu.demo.cajero.service;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;

public interface IDetalleService {
    public Detalle buscar(Integer id);

    public void actualizar(Detalle deta);

    public void eliminar(Integer id);

    public void insertar(Detalle deta);
}
