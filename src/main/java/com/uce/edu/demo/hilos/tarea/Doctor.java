package com.uce.edu.demo.hilos.tarea;

import java.util.List;

public class Doctor {

	private String nombre;
	private List<String> paciente;

	public Doctor(String nombre, List<String> paciente) {
		this.paciente = paciente;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<String> paciente) {
		this.paciente = paciente;
	}
	
	
}
