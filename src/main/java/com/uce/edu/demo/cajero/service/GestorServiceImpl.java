package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorServiceImpl implements IGestorService {

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void compraProductos(String cedulaCliente, String numeroFactura, List<String> codigos) {	
		
		BigDecimal monto = this.facturaService.procesarFactura(cedulaCliente, numeroFactura, codigos);
		this.facturaElectronicaService.procesarElectronica(numeroFactura, codigos.size(), monto);
	}
    

}