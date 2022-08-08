package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3KtApplication implements CommandLineRunner {

	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info(">>>Relacionamiento WHERE");
		List <Factura> listaFacturaWhere=this.iFacturaService.buscarFacturaJoinWhere(10);
		for(Factura f : listaFacturaWhere) {
			log.info("		Factura Where: "+f.getNumero()+" "+f.getFecha());
		}
		
		log.info(">>>JOIN FECHT");
		List <Factura> listaFacturas3=this.iFacturaService.buscarFacturaJoinFetch(10);
		for(Factura f : listaFacturas3) {
			log.info("		Factura3 : "+f.getNumero()+" "+f.getFecha());
			for(DetalleFactura de: f.getDetalles()) {
				log.info("		DetallerFacura3: "+de);		
			}
		}

	}

}
