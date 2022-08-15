package com.uce.edu.demo.respository;

import com.uce.edu.demo.respository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscarPorNumero(String numeroCta);
	

}
