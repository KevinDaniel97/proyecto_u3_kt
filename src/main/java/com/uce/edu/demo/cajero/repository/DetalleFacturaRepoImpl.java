package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo{
	

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleFactura detalleFactura) {
		this.entityManager.persist(detalleFactura);
		
	}
}
