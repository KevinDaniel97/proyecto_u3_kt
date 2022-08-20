package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;



@SpringBootApplication
public class ProyectoU3KtApplication implements CommandLineRunner {

private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	
	@Autowired
	private ITransferenciaService iTransfernciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		this.iTransfernciaService.realizarTransferenciaFachada("0001", "0002", new BigDecimal(1));

	}

}
