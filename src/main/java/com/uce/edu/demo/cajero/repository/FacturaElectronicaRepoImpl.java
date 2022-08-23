package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.FacturaElectronica;
@Repository
@Transactional
public class FacturaElectronicaRepoImpl implements IFacturaElectronicaRepo{
	
	
	
	@PersistenceContext
	private EntityManager e;

	@Override
	public void insertar(FacturaElectronica fatr) {
		this.e.persist(fatr);
		
	}
}
