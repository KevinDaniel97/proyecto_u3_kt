package com.uce.edu.demo.cajero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IFacturaRepo;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {

	
	@Autowired
	private IFacturaRepo factRepo ;
	
	@Override
	public Factura buscar(Integer id) {
		
		return this.factRepo.buscar(id);
	}

	

	@Override
	public void actualizar(Factura fact) {
		this.factRepo.actualizar(fact);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.factRepo.eliminar(id);
		
	}

	@Override
	public void insertar(Factura fact) {
		this.factRepo.insertar(fact);
		
	}



	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.factRepo.buscarNumero(numero);
	}

}