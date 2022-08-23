package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU3KtApplication;
import com.uce.edu.demo.cajero.repository.modelo.Cliente;
@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);


    @PersistenceContext
    private EntityManager e;

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente buscar(Integer id) {
        return this.e.find(Cliente.class, id);
    }

    @Override
    public void actualizar(Cliente clie) {
        this.e.merge(clie);

    }

    @Override
    public void eliminar(Integer id) {
        Cliente gBorrar = this.buscar(id);
        this.e.remove(gBorrar);

    }

    @Override
    public void insertar(Cliente clie) {
        this.e.persist(clie);

    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente buscarCedula(String cedula) {
        TypedQuery<Cliente> myTypedQuery = this.e
                .createQuery("SELECT c FROM Cliente c  WHERE c.cedula = :cedula  ", Cliente.class)
                .setParameter("cedula", cedula);
        return myTypedQuery.getSingleResult();
    }



	
}
