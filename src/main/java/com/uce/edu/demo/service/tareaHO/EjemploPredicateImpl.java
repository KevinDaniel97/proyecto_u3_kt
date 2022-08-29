package com.uce.edu.demo.service.tareaHO;


public class EjemploPredicateImpl implements IEjemploPredicate<String>{

	
	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		return arg1.isBlank()?true:false;
	}
}
