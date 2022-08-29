package com.uce.edu.demo.service.tareaHO;

@FunctionalInterface
public interface IEjemploConsumer<T> {

	public void accept(T arg1);
}
