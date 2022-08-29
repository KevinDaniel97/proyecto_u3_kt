package com.uce.edu.demo.service.tareaHO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class MainInterfacesFuncioanles {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		
		
		//SUPPLIER
		//CLASES 
		IEjemploSupplier<BigDecimal > supplier= new EjemploSupplierImpl();
		log.info("Supplier clase: "+supplier.get());
		
		//Lambdas
		IEjemploSupplier<BigDecimal > supplierLambda=()->new BigDecimal("1.1");
		log.info("Supplier Lambda: "+supplierLambda.get());
		
		//Metodos High Order
		log.info("HO Supplier "+ metodosHO.consumirSupplier(supplierLambda, 1));
		
		
		//Java
		
		//CONSUMER
		//CLASES 
		IEjemploConsumer<BigDecimal> consumerClase=new EjemploConsumerImpl();
		consumerClase.accept(new BigDecimal("1000"));
		//Lambdas
		IEjemploConsumer<BigDecimal>consumerLamda=val-> System.out.println(val+" es "+val.getClass());
		consumerLamda.accept(new BigDecimal("1000"));
		//Metodos High Order
		metodosHO.consumirConsumer(consumerLamda, 1000);
		
		//PREDICATE 
		//CLASES 
		IEjemploPredicate<String> predicate = new EjemploPredicateImpl();
		log.info("Predicate Clase: "+predicate.evaluar("n"));
		//Lambdas
		IEjemploPredicate<String> predicateLambda= cadena-> cadena.isBlank();
		log.info("Predicate Lambdas: "+predicateLambda.evaluar(""));
		
		//Metodos High Order
		metodosHO.consumirPredicate(predicateLambda, "100");
		
		// Function
       
        // Interfaz
        
        // Lambda
        IEjemploFunction<Integer,Boolean> functionLambda = arg1 -> {
            Integer valor ;
        if (arg1 == true ) {
            valor = 2;
        }else{  
            valor = 3;
        }
        return valor;
        };
        log.info(functionLambda.aplicar(true));

 
        // Interfaz
        IEjemploUnaryOperator<LocalDateTime> examenUnaryOperator = new EjemploUnaryOperator();
        log.info(examenUnaryOperator.apply(LocalDateTime.now()));
        // Lambda
        IEjemploUnaryOperator<LocalDateTime> unaryOperatorLambda =  arg1 -> arg1.minusYears(50);
        log.info(unaryOperatorLambda.apply(LocalDateTime.now()));
       
	}

}
