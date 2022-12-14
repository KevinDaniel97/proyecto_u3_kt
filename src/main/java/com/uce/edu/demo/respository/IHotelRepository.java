package com.uce.edu.demo.respository;

import java.util.List;

import com.uce.edu.demo.respository.modelo.Hotel;

public interface IHotelRepository {

	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelOuterhJoinRight(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLeft();

	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);
	public List<Hotel> buscarHotelJoinFetech(String tipoHabitacion);


}
