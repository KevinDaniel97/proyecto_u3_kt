package com.uce.edu.demo.cajero.service;

import java.util.List;

public interface IGestorService {
	public void compraProductos(String cedulaCliente, String numeroFactura, List<String> codigos);

}
