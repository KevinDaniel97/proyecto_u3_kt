package com.uce.edu.demo.service.tareaHO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class MainInterfacesFuncioanles {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	public static void main(String[] args) {
		
		String[] lista = { "uno", "dos", "tres", "cuatro", "cinco" };
	
		Stream<String> streamLista = Stream.of(lista);
		// JAVA
		
		// SUPPLIER
		log.info("Java Stream Supplier");
		Stream<String> streamSupplier = Stream.of("Ana", "Pedro", "Carlos", "Marcos");
		List<String> streamSupplierProcesado = streamSupplier
				.collect(Collectors.toCollection(() -> new ArrayList<String>()));
		log.info(streamSupplierProcesado);
		
		// FUNCTION
		log.info("Java Stream Function");
		Stream<String> listaMayus = streamLista.map(cadena -> {
			String mayus = cadena.toUpperCase();
			return mayus;
		});
		
		// CONSUMER
		log.info("Java Stream consumer");
		listaMayus.forEach(mayus -> {
			log.info("Numero: " + mayus);
		});
		Stream.of(lista);


		// PREDICATE
		log.info("Java Stream Predicate");
		Stream<String> streamSPredicate = Stream.of("Ana", "Pedro", "Carlos", "Marcos","Angel","Anabel");
		streamSPredicate.filter(n -> n.startsWith("A")).forEach(System.out::println);




	}

}
