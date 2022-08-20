package com.uce.edu.demo.respository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.respository.modelo.Transferencia;
@Repository
@Transactional
public class TransferenciaRespositoryImpl implements ITransfernciaRespository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value= TxType.REQUIRED)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		throw new RuntimeException();
	}

}
