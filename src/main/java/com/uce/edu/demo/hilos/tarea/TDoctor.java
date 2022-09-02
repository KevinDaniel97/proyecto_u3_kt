package com.uce.edu.demo.hilos.tarea;

import java.util.concurrent.TimeUnit;

public class TDoctor extends Thread {

	Doctor doctor;

	public TDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public void run() {
		this.procesar(this.doctor);
	}

	public void procesar(Doctor doctor) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("\n----> Nombre Hilo Procesar: " + Thread.currentThread().getName()+" "+doctor.getNombre());
		System.out.println("Pacientes atendidos por el doctor/a:" + doctor.getNombre().toUpperCase());
		for (String paciente : doctor.getPaciente()) {
			this.atencion(paciente);
			System.out.println();
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("\nTerminó: " + doctor.getNombre() + " en " + tiempoTranscurrido + "seg");
	}

	public void atencion(String paciente) {
		System.out.print("Atendiendo a: " + paciente+" ");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
