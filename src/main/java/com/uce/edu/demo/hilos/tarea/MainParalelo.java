package com.uce.edu.demo.hilos.tarea;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		System.out.println("*********CON sleep(5)**********");
		long tiempoInicial = System.currentTimeMillis();

		Doctor d1= new Doctor("Kevin", Arrays.asList("paciente1", "paciente2", "paciente3"));
		Doctor d2= new Doctor("Daniel", Arrays.asList("paciente4", "paciente5", "paciente6", "paciente7"));
		Doctor d3 = new Doctor("Sandro", Arrays.asList("paciente8", "paciente9", "paciente9", "paciente10", "paciente11"));
		Doctor d4 = new Doctor("Daysi", Arrays.asList("paciente12", "paciente13", "paciente14", "paciente15", "paciente16", "paciente17"));
		Doctor d5 = new Doctor("Matias", Arrays.asList("paciente18", "paciente19"));

		TDoctor gestorAtencion1 = new TDoctor(d1);
		gestorAtencion1.start();
		TDoctor gestorAtencion2  = new TDoctor(d2);
		gestorAtencion2.start();
		TDoctor gestorAtencion3  = new TDoctor(d3);
		gestorAtencion3.start();
		TDoctor gestorAtencion4  = new TDoctor(d4);
		gestorAtencion4.start();
		TDoctor gestorAtencion5  = new TDoctor(d5);
		gestorAtencion5.start();
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg");
	}
}
