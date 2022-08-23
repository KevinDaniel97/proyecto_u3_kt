package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Cliente;

public interface IClienteRepo {
    public Cliente buscar(Integer id);

    public void actualizar(Cliente clie);

    public void eliminar(Integer id);

    public void insertar(Cliente clie);

    public Cliente buscarCedula(String cedula);
}
