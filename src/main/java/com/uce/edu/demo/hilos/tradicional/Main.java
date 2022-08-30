package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Proceso con 2 segundos");
		long tiempoInicial=System.currentTimeMillis();
		Cajero c1=new Cajero("Kevin",Arrays.asList("pepito", "juan", "Daniel","pedro"));
		Cajero c2=new Cajero("luis",Arrays.asList("pepito2", "juan2", "Daniel2"));
		Cajero c3=new Cajero("paul",Arrays.asList("pepito3", "juan3"));

		PCCajero gestorAtencion=new PCCajero();
		gestorAtencion.procesar(c1);
		gestorAtencion.procesar(c2);
		gestorAtencion.procesar(c3);

		
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido+" seg");
	}

}
