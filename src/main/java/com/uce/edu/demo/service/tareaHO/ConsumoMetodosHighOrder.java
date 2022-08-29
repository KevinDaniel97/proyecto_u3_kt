package com.uce.edu.demo.service.tareaHO;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class ConsumoMetodosHighOrder {

	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	
	public String consumirSupplier(IEjemploSupplier<BigDecimal> funcion, Integer val) {
        
		BigDecimal num = funcion.get().add(new BigDecimal(val));
		
		return num.toEngineeringString();
	}
	public void consumirConsumer(IEjemploConsumer<BigDecimal> funcion, Integer valor) {
		funcion.accept(new BigDecimal(valor));
	}
	
	
	public boolean consumirPredicate(IEjemploPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}
	public String consumirFunction(IEjemploFunction<String, Integer> funcion, Integer valor ) {
		return funcion.aplicar(valor);
	}
	

}
