package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.cajero.repository.modelo.Cliente;
import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.cajero.repository.modelo.Producto;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private IDetalleService detalleService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IFacturaElectronicaRepo faElectronicaRepo;

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void crearDetallesFactura(String cedulaCliente, String numeroFactura, List<String> codigos) {
        Cliente cliente = this.clienteService.buscarCedula(cedulaCliente);
        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setNumero(numeroFactura);
        factura.setFecha(LocalDateTime.now());
        this.facturaService.insertar(factura);
        BigDecimal monto  = new BigDecimal("0");
        Integer items = 0;

        for (String cod : codigos) {
            Detalle detalle = new Detalle();
            detalle.setCantidad(1);
            detalle.setFactura(factura);
            Producto p = this.productoService.buscarCodigoBarras(cod);
            detalle.setProducto(p);
            BigDecimal subtotal = p.getPrecio().multiply(new BigDecimal(detalle.getCantidad()));
            detalle.setSubtotal(subtotal);
            this.detalleService.insertar(detalle);

            items = items + detalle.getCantidad();
            monto = monto.add(subtotal);
            actualizarStock(p, detalle.getCantidad());
        }
        factura.setMonto(monto);
        this.facturaService.actualizar(factura);
        
        crearFacturaElectronica(numeroFactura, monto, items);   
    }
    
    @Transactional(value = TxType.REQUIRED)
    public void actualizarStock(Producto p, Integer cantidad) {
        p.setStock(p.getStock() - cantidad);
        this.productoService.actualizar(p);
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items ) {
        FacturaElectronica facturaElectronica = new FacturaElectronica();
        facturaElectronica.setFechaCreacion(LocalDateTime.now());
        facturaElectronica.setMonto(monto);
        facturaElectronica.setNumItems(items);
        facturaElectronica.setNumero(numeroFact);
        this.faElectronicaRepo.insertar(facturaElectronica);
        throw new RuntimeException();

    }

}