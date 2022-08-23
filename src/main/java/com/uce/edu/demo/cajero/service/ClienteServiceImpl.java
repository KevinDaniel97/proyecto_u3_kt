package com.uce.edu.demo.cajero.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU3KtApplication;
import com.uce.edu.demo.cajero.repository.IClienteRepo;
import com.uce.edu.demo.cajero.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

    @Autowired
    private IClienteRepo clieRepo;

    @Override
    public Cliente buscar(Integer id) {

        return this.clieRepo.buscar(id);
    }

    @Override
    public void actualizar(Cliente clie) {
        this.clieRepo.actualizar(clie);

    }

    @Override
    public void eliminar(Integer id) {
        this.clieRepo.eliminar(id);

    }

    @Override
    public void insertar(Cliente clie) {
        this.clieRepo.insertar(clie);

    }

    @Override
    public Cliente buscarCedula(String cedula) {
        
        return this.clieRepo.buscarCedula(cedula);
    
	}

}
