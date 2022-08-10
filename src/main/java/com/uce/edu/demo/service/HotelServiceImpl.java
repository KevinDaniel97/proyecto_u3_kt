package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.respository.HotelRepositoryImpl;
import com.uce.edu.demo.respository.IHotelRepository;
import com.uce.edu.demo.respository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	private static Logger log = Logger.getLogger(HotelRepositoryImpl.class);

	
	@Autowired
	private IHotelRepository iHotelRepository;

	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterhJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterhJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft();
	}
	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFintech(String tipoHabitacion) {
		// TODO Auto-generated method stub
		log.info("Transaccion Activa Repository: "+ TransactionSynchronizationManager.isActualTransactionActive());
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

	

}
