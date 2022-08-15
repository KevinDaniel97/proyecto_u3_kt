package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.libroAutor.repository.modelo.Libro;
import com.uce.edu.demo.libroAutor.service.ILibroService;

@SpringBootApplication
public class ProyectoU3KtApplication implements CommandLineRunner {

	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	

//	@Autowired
//	private ILibroService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//	Libro libro1= new Libro();
//	libro1.setTitulo("bbb");
//	libro1.setCantidadPaginas(10);
//	//this.service.insertar(libro1);
//	
//	List<Libro> lib= this.service.contarCantidadPaginas(80);
//	for(Libro item: lib) {
//		log.info(lib);
//	}
		
	}

}
