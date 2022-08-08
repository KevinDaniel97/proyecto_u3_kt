package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// Inner
		List<Factura> listaFacturas = this.iFacturaService.buscarFacturaInnerJoin(2);
		for (Factura f : listaFacturas) {
			log.info("		Factura INNER: " + f.getNumero() + " " + f.getFecha());
		}
		List<Factura> listaFactura2 = this.iFacturaService.buscarFacturaInnerJoin();
		for (Factura f : listaFactura2) {
			log.info("		Factura INNER 2: " + f.getNumero() + " " + f.getFecha());
		}
		// right
		List<Factura> listaFacturasRight = this.iFacturaService.buscarFacturaOuterJoinRight(2);
		for (Factura f : listaFacturasRight) {
			log.info("		Factura RIGHT: " + f.getNumero() + " " + f.getFecha());
		}
		// Left
		List<Factura> listaFacturasLeft = this.iFacturaService.buscarFacturaOuterJoinLeft(2);
		for (Factura f : listaFacturasLeft) {
			log.info("		Factura LEFT: " + f.getNumero() + " " + f.getFecha());
		}

		List<Factura> listaFacturasLeft2 = this.iFacturaService.buscarFacturaOuterJoinLeft();
		for (Factura f : listaFacturasLeft2) {
			log.info("		Factura LEFT2: " + f.getNumero() + " " + f.getFecha());
		}

	}

}
