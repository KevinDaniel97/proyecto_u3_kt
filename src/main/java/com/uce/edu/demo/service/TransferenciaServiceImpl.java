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
	private ICuentaBancariaRepository cuentaBancariaRepo;
	@Autowired
	private ITransfernciaRespository transferenciaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String CtaOrigen, String CtaDestino, BigDecimal monto) {
		CuentaBancaria origen=this.cuentaBancariaRepo.buscarPorNumero(CtaOrigen);
		CuentaBancaria destino=this.cuentaBancariaRepo.buscarPorNumero(CtaDestino);
		//encontramos las cuentas
		BigDecimal saldoOrigen=origen.getSaldo();
		BigDecimal saldoDestino=destino.getSaldo();
		//obtenemos los valores de los saldos
		BigDecimal saldoActualOrigen=saldoOrigen.subtract(monto);
		BigDecimal saldoActualDestino=saldoDestino.add(monto);
		//sumamos en el destino y restamos en el origen
		origen.setSaldo(saldoActualOrigen);
		destino.setSaldo(saldoActualDestino);
		//cambiamos los valores
		this.cuentaBancariaRepo.actualizar(origen);
		this.cuentaBancariaRepo.actualizar(destino);
		//actualizamos en DB
		Transferencia trans=new Transferencia();
		trans.setCuentaOrigen(origen);
		trans.setCuentaDestino(destino);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		//seteamos la transferencia
		this.transferenciaRepo.insertar(trans);
		//insertamos la transferencia
	}

	@Override
	public void insertarCuenta(CuentaBancaria bancaria) {
		this.cuentaBancariaRepo.insertar(bancaria);
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String CtaOrigen, String CtaDestino, BigDecimal monto) {
		this.realizarTransferencia(CtaOrigen, CtaDestino, monto);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		return this.cuentaBancariaRepo.buscarPorNumero(numeroCuenta);
	}


}
