package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.cajero.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepo facturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setFecha(LocalDateTime.now());
		facturaElectronica.setMonto(monto);
		facturaElectronica.setNumItems(cantidadItems);

		this.facturaElectronicaRepository.insertar(facturaElectronica);
		throw new RuntimeException();
		
	}

}
