package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {

	public void procesar(Cajero cajero) {
		System.out.println("nombre hilo procesar: "+Thread.currentThread().getName());
		System.out.println("procesando cajero: "+cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
		this.atenderCliente(cliente);	
			
		}
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+cliente);
		//demorar el metodo 10 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
