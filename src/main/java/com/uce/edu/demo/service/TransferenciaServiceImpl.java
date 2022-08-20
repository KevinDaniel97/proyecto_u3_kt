package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.respository.ICuentaBancariaRepository;
import com.uce.edu.demo.respository.ITransfernciaRespository;
import com.uce.edu.demo.respository.modelo.CuentaBancaria;
import com.uce.edu.demo.respository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	@Autowired
	private ITransfernciaRespository iTransfernciaRespository;
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW )
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//0.Busque la cuenta origen
		CuentaBancaria ctaOrigen=this.bancariaRepository.buscarPorNumero(numeroCtaOrigen);
		//1. restar el monto a la cta origen
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoFinal=saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		//0. buscar la cta destino
		CuentaBancaria ctaDestino=this.bancariaRepository.buscarPorNumero(numeroCtaDestino);
		//2 sumar el monto la cta origen
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		
		//3 insertar transferencia
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransfernciaRespository.insertar(trans);
		
	
//		if(ctaOrigen.getTipo().equals("Ahorros")){
//			throw new RuntimeException();
//		}
		if(monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
		}
		
	}//commit

	@Override
	@Transactional(value=TxType.REQUIRED )
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

	@Override
	public void insertarCuenta(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		return null;
	}


}
