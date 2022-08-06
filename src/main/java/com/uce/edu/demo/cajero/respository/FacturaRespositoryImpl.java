package com.uce.edu.demo.cajero.respository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.respository.modelo.Hotel;
@Repository
@Transactional
public class FacturaRespositoryImpl implements IFacturaRespository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		 return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.cantidad =:cantidad ",Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d",Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad =:cantidad ",Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d",Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterhJoinRight(Integer cantidad) {
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad =:cantidad ",Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	
}
