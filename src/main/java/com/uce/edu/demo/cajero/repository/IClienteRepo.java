package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Cliente;

public interface IClienteRepo {
    public Cliente buscar(String id);

}
