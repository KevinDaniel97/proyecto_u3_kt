package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajero;
	
	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero=cajero;
		
	}
	
	//disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}
	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial=System.currentTimeMillis();

		System.out.println("nombre hilo procesar: "+Thread.currentThread().getName());
		System.out.println("procesando cajero: "+cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);	
		}
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("termino: "+cajero.getNombre()+" *********** "+tiempoTranscurrido+" seg");

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
