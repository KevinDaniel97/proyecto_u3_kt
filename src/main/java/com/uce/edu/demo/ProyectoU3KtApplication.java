package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.respository.modelo.Habitacion;
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
		
		log.info("RelacionamieNto Where");
		List <Hotel> listaHotelWhere=this.iHotelService.buscarHotelJoinWhere("Familia");
		for(Hotel h : listaHotelWhere) {
			log.info("Hotel Where: "+h.getNombre()+" "+h.getDireccion());
		}
		
		log.info("Inner JOIN EAGER/LAZY");
		List <Hotel> listaHoteles2=this.iHotelService.buscarHotelInnerJoin("Familia");
		for(Hotel h : listaHoteles2) {
			log.info("Hotel2 : "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				log.info("Habitacion2: "+ha);	
				
			}
		}
		log.info(" JOIN FECHT");
		List <Hotel> listaHoteles3=this.iHotelService.buscarHotelJoinFintech("Familia");
		for(Hotel h : listaHoteles3) {
			log.info("Hotel3 : "+h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				log.info("Habitacion3: "+ha);	
				
			}
		}
		
	}

}
