package com.uce.edu.demo.service.tareaHO;

import java.time.LocalDateTime;

public class EjemploUnaryOperator implements IEjemploUnaryOperator<LocalDateTime> {

	

	@Override
	public LocalDateTime apply(LocalDateTime arg1) {
		// TODO Auto-generated method stub
		return arg1.minusDays(15);
	}

}
