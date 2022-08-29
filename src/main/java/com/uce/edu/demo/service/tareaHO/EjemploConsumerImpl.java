package com.uce.edu.demo.service.tareaHO;

import java.math.BigDecimal;

public class EjemploConsumerImpl implements IEjemploConsumer<BigDecimal>{

	@Override
	public void accept(BigDecimal  arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg1+" es "+arg1.getClass());
	}

}
