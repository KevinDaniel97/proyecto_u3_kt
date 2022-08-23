package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaRepo {

	public Factura buscar(Integer id);

	public void actualizar(Factura fact);

	public void eliminar(Integer id);

	public void insertar(Factura fact);
	
	public Factura buscarNumero(String numero);
}
