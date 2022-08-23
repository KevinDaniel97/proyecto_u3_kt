package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;

@Repository
@Transactional
public class DetalleRepoImpl implements IDetalleRepo{
	

	@PersistenceContext
	private EntityManager e;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Detalle buscar(Integer id) {
		return this.e.find(Detalle.class, id);
	}

	
	@Override
	public void actualizar(Detalle deta) {
		this.e.merge(deta);
		
	}

	@Override
	public void eliminar(Integer id) {
		Detalle gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Detalle deta) {
		this.e.persist(deta);
		
	}
}
