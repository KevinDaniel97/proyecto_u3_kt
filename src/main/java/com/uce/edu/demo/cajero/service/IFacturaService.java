package com.uce.edu.demo.cajero.service;

import java.util.List;

import com.uce.edu.demo.cajero.modelo.Factura;

public interface IFacturaService {

	public Factura consultar(Integer id);
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buscarFacturaInnerJoin();

	
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura> buscarFacturaOuterJoinLeft();
	
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	
}
