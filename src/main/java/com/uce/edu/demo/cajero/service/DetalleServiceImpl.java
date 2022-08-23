package com.uce.edu.demo.cajero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IDetalleRepo;
import com.uce.edu.demo.cajero.repository.modelo.Detalle;

@Service
public class DetalleServiceImpl implements IDetalleService {


    @Autowired
    private IDetalleRepo detaRepo;

    @Override
    public Detalle buscar(Integer id) {

        return this.detaRepo.buscar(id);
    }


    @Override
    public void actualizar(Detalle deta) {
        this.detaRepo.actualizar(deta);

    }

    @Override
    public void eliminar(Integer id) {
        this.detaRepo.eliminar(id);

    }

    @Override
    public void insertar(Detalle deta) {
        this.detaRepo.insertar(deta);

    }

}