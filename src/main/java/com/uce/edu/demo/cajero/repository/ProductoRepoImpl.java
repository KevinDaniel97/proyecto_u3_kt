package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Producto;
@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(String codigo) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarra", Producto.class);
		myQuery.setParameter("codigoBarra", codigo);
		return myQuery.getSingleResult();
	}
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

	
}