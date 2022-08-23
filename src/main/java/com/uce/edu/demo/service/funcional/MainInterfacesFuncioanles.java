package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class MainInterfacesFuncioanles {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SUPPLIER
		//CLASES 
		IPersonaSupplier<String > supplier= new PersonaSupplierImpl();
		log.info("Supplier clase: "+supplier.getNombre());
		
		IPersonaSupplier<String > supplierTE= new PersonaSupplierTEImpl();
		log.info("Supplier clase: "+supplierTE.getNombre());
		//Lambdas
		IPersonaSupplier<String > supplierLambda=()->"Kevin 2";
		log.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String > supplierLambdaTE=()->"Daniel TE2";
		log.info("Supplier Lambda: "+supplierLambdaTE.getNombre());
		
		//Java
		
		//CONSUMER
		//CLASES 
		IPersonaConsumer<String> consumerClase=new IPersonaConsumerImpl();
		consumerClase.accept("prueba consumer");
		
		IPersonaConsumer<String>consumerLamda=cadena-> System.out.println(cadena);
		consumerLamda.accept("Prueba consumer Lambda");
		
		//Lambdas
		
		//PREDICATE 
		//CLASES 
		//Lambdas
		
		//FUNCTION
		//CLASES 
		//Lambdas
		
		//UNARY OPERATOR (FUNCTION)
		//CLASES 
		//Lambdas
		
	}

}
