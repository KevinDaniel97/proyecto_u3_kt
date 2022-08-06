package com.uce.edu.demo.cajero.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="producto")
public class Producto {

	@Id
	@Column(name="prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_sec")
	@SequenceGenerator(name = "prod_id_sec", sequenceName = "prod_id_sec", allocationSize = 1)
	private Integer id;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy="producto")
	private List<DetalleFactura> detalles;
	
	//set yget
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	
}
