package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Proceso con 5 segundos");
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("nombre hilo: "+Thread.currentThread().getName());
		
		Cajero c1=new Cajero("Kevin",Arrays.asList("pepito", "juan"));
		Cajero c2=new Cajero("luis",Arrays.asList("pepito2", "juan2"));
		Cajero c3=new Cajero("paul",Arrays.asList("pepito3", "juan3"));

		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(c1);
		
		PCCajero gestorAtencion2=new PCCajero();
		gestorAtencion2.procesar(c2);
		
		PCCajero gestorAtencion3=new PCCajero();
		gestorAtencion3.procesar(c3);

		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("Tiempo transcurrido: "+tiempoTranscurrido+" seg");
	}

}
