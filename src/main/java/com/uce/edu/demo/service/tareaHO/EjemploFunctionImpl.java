package com.uce.edu.demo.service.tareaHO;

public class EjemploFunctionImpl implements IEjemploFunction<Integer, Boolean>{

    @Override
    public Integer aplicar(Boolean arg1) {
        Integer valor ;
        if (arg1 == true ) {
            valor = 1;
        }else{  
            valor = 0;
        }
        return valor;
    }
}
