package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProyectoU3KtApplication implements CommandLineRunner {

	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}

}
