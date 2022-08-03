package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.respository.modelo.Hotel;

public interface IHotelService {
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelInnerJoin();
	public List<Hotel> buscarHotelOuterhJoinRight(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLeft();
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);
	public List<Hotel> buscarHotelJoinFintech(String tipoHabitacion);

}
