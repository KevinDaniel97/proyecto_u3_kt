package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.ProyectoU3KtApplication;

public class MainInterfacesFuncioanles {
	private static Logger log = Logger.getLogger(ProyectoU3KtApplication.class);

	public static boolean prueba(Integer numero){
		return numero>=3;
	}
	public static  void imprimir(String cadena) {
		log.info("impresion: "+cadena);
	}
	public static  void guardar(String elementoAIntertar) {
		log.info("guardar: "+elementoAIntertar);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		
		
		
		
		
		//SUPPLIER-----------------------------------------------------------------------------------
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
		
		//JAVA
		log.info("JAVA supplier ");
		Stream<String> test =Stream.generate(()->"Kevin 3").limit(2);
		test.forEach(cadena->System.out.println(cadena));
		
		
		//CONSUMER--------------------------------------------------------------------------------------------------
		//CLASES 
		IPersonaConsumer<String> consumerClase=new IPersonaConsumerImpl();
		consumerClase.accept("prueba consumer");
		//Lambdas
		IPersonaConsumer<String>consumerLamda=cadena-> System.out.println(cadena);
		consumerLamda.accept("Prueba consumer Lambda");
		//Metodos High Order
		metodosHO.consumirConsumer(valor-> System.out.println(valor), 2);
		//JAVA
		log.info("JAVA Consumer");
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero->System.out.println(numero));	
	
		//PREDICATE -------------------------------------------------------------------------------------------------
		//CLASES 
		//Lambdas
		IPersonaPredicate<String> predicateLambda= cadena-> cadena.contains("Z");
		log.info("Predicate Lambdas: "+predicateLambda.evaluar("KevinZ"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena-> cadena.contains("M"), "KevinZ");
		log.info("HO PREDICATE: "+respuesta);
		//JAVA 
		log.info("JAVA Predicate");
		Stream<Integer>nuevaLista=listaNumeros.stream().filter(numero->numero>=3);
		nuevaLista.forEach(numero-> System.out.println(numero));
		
		//FUNCTION---------------------------------------------------------------------------------------------------
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
			return retorn;
		}, 1);
		log.info("HO FUNCTION: "+valorFinalHO);
		//JAVA
		log.info("JAVA Fuction");
		//Conversiones/cast Empleado-> Empleado(Ligero)
		Stream <String>listaCambiada=listaNumeros.stream().map(numeroLista-> {
			Integer valor = numeroLista+1;
			String cadena = "nume: "+valor.toString();
			return cadena;
		});
		
		//Declarativa:ideas/intenciones
		//listaCambiada.forEach(valor->imprimir(valor));
		listaCambiada.forEach(valor-> guardar(valor));
		
//		List<String> lista1 new ArrayList();
//		Map<String,String> mapa1= new HashMap<String,String>();
		
		//Imperativa: paso a paso
//		for(String valor:) {
//			imprimir(valor);
//		}
		
		
		//UNARY OPERATOR (FUNCTION)-----------------------------------------------------------------------------------
		//CLASES 
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda= cade-> {
			String valorFinal=cade.concat(" sufijo");
			return valorFinal;
		};
		log.info("unary lamabda: "+unaryLambda.apply("Daniel"));
		
		
		
	}

}
