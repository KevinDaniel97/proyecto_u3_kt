package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class MainInterfacesFuncioanles {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		
		
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
		
		//Metodos High Order
		String valorHO=metodosHO.consumirSupplier(()->"Hola Mundo");
		log.info("HO Supplier "+ valorHO );
		
		String valorHO1=metodosHO.consumirSupplier(()->{
				String valorConsultado ="1712452";
			return valorConsultado;}
		);
		log.info("HO Supplier "+ valorHO1 );
		
		//Java
		
		//CONSUMER
		//CLASES 
		IPersonaConsumer<String> consumerClase=new IPersonaConsumerImpl();
		consumerClase.accept("prueba consumer");
		//Lambdas
		IPersonaConsumer<String>consumerLamda=cadena-> System.out.println(cadena);
		consumerLamda.accept("Prueba consumer Lambda");
		//Metodos High Order
		metodosHO.consumirConsumer(valor-> System.out.println(valor), 2);
		
		//PREDICATE 
		//CLASES 
		//Lambdas
		IPersonaPredicate<String> predicateLambda= cadena-> cadena.contains("Z");
		log.info("Predicate Lambdas: "+predicateLambda.evaluar("KevinZ"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena-> cadena.contains("M"), "KevinZ");
		log.info("HO PREDICATE: "+respuesta);
		//FUNCTION
		//CLASES 
		//Lambdas
		IPersonaFunction<Integer, String>funtionLambda= cadena -> {
			Integer valor =Integer.parseInt(cadena);
			Integer valorFinal =valor-2;
			return valorFinal;
			};
		log.info("Funtion Lambda: "+funtionLambda.aplicar("7"));
		//Metodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor -> {
			String retorn= valor.toString()+"A";
			//......
			return retorn;
		}, 1);
		log.info("HO FUNCTION: "+valorFinalHO);

		
		//UNARY OPERATOR (FUNCTION)
		//CLASES 
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda= cade-> {
			String valorFinal=cade.concat(" sufijo");
			return valorFinal;
		};
		log.info("unary lamabda: "+unaryLambda.apply("Daniel"));
		
		
		
	}

}
