package com.uce.edu.demo.cajero.service;

import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaService {

	 public Factura buscar(Integer id);

	    public void actualizar(Factura fact);

	    public void eliminar(Integer id);

	    public void insertar(Factura fact);

	    public Factura buscarNumero(String numero);

}
