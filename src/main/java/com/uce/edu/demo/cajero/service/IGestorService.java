package com.uce.edu.demo.cajero.service;

public interface IGestorService {
    public void crearDetallesFactura(String cedulaCliente, String numeroFactura, List<String> codigos);

}
