package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.libroAutor.repository.ILibroRepository;
import com.uce.edu.demo.libroAutor.repository.modelo.Libro;

@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class Ejemplo3 {
	
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	@Autowired
	private ILibroRepository iLibroRepository;
	
	@Test
	public void testCantidadPaginas() {
	
		List<Libro> libroCant=this.iLibroRepository.contarCantidadPaginas(50);
		assertThat(libroCant).size().isGreaterThan(0);
		log.info(libroCant);
	
	}
	
}
