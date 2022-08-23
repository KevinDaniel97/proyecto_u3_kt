package com.uce.edu.demo.cajero.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;
@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {


	@PersistenceContext
	private EntityManager e;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscar(Integer id) {
		return this.e.find(Factura.class, id);
	}

	@Override
	public void actualizar(Factura fact) {
		this.e.merge(fact);

	}

	@Override
	public void eliminar(Integer id) {
		Factura gBorrar = this.buscar(id);
		this.e.remove(gBorrar);

	}

	@Override
	public void insertar(Factura fact) {
		this.e.persist(fact);

	}

	
	@Override
	public Factura buscarNumero(String numero) {
		TypedQuery<Factura> myTypedQuery = this.e
				.createQuery("SELECT f FROM Factura f  WHERE f.numero = :numero  ", Factura.class)
				.setParameter("numero", numero);
		return myTypedQuery.getSingleResult();
	}

}
