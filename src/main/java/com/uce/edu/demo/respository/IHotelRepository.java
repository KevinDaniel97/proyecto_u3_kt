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
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);
	
	 public void insertar(Hotel hotel);
	    
	 public void actualizar(Hotel hotel);
	    
	 public Hotel buscarPorNombre(String nombre);


}
