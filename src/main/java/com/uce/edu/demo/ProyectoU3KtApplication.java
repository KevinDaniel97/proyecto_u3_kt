package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;



@SpringBootApplication
public class ProyectoU3KtApplication implements CommandLineRunner{
	
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List <Hotel> listaHoteles=this.iHotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h : listaHoteles) {
			log.info("Hotel INNER: "+h.getNombre()+" "+h.getDireccion());
		}
		
		List <Hotel> listaHotelesRight=this.iHotelService.buscarHotelOuterhJoinRight("Familiar");
		for(Hotel h : listaHotelesRight) {
			log.info("Hotel RIGHT: "+h.getNombre()+" "+h.getDireccion());
		}
		List <Hotel> listaHotelesLeft=this.iHotelService.buscarHotelOuterJoinLeft("Familiar");
		for(Hotel h : listaHotelesLeft) {
			log.info("Hotel LEFT: "+h.getNombre()+" "+h.getDireccion());
		}
		
		List <Hotel> listaHotelesLeft2=this.iHotelService.buscarHotelOuterJoinLeft();
		for(Hotel h : listaHotelesLeft2) {
			log.info("Hotel LEFT2: "+h.getNombre()+" "+h.getDireccion());
		}
		List <Hotel> listaHoteles2=this.iHotelService.buscarHotelInnerJoin();
		for(Hotel h : listaHoteles2) {
			log.info("Hotel INNER 2: "+h.getNombre()+" "+h.getDireccion());
		}
		
		
	}

}
