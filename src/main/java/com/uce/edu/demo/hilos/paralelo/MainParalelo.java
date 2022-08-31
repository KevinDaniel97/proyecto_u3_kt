package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*************Proceso con 5 segundos***************");
		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		
		CajeroParalelo c1=new CajeroParalelo("Kevin",Arrays.asList("pepito"));
		CajeroParalelo c2=new CajeroParalelo("luis",Arrays.asList("pepito2"));
		CajeroParalelo c3=new CajeroParalelo("paul",Arrays.asList("pepito3"));
		CajeroParalelo c4=new CajeroParalelo("Kevin",Arrays.asList("pepito"));
		CajeroParalelo c5=new CajeroParalelo("luis",Arrays.asList("pepito2"));
		CajeroParalelo c6=new CajeroParalelo("paul",Arrays.asList("pepito3"));
		//kevin
		PCCajeroParalelo gestorAtencion=new PCCajeroParalelo(c1);
		gestorAtencion.start();//PROCEAR
		//luis
		PCCajeroParalelo gestorAtencion2=new PCCajeroParalelo(c2);
		gestorAtencion2.start();
		//paul
		PCCajeroParalelo gestorAtencion3=new PCCajeroParalelo(c3);
		gestorAtencion3.start();

		//kevin
		PCCajeroParalelo gestorAtencion4=new PCCajeroParalelo(c4);
		gestorAtencion4.start();//PROCEAR
		//luis
		PCCajeroParalelo gestorAtencion5=new PCCajeroParalelo(c5);
		gestorAtencion5.start();
		//paul
		PCCajeroParalelo gestorAtencion6=new PCCajeroParalelo(c6);
		gestorAtencion6.start();

	}

}
