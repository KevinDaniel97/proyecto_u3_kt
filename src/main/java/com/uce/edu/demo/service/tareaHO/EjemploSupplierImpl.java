package com.uce.edu.demo.service.tareaHO;

import java.math.BigDecimal;

public class EjemploSupplierImpl implements  IEjemploSupplier<BigDecimal>{

    @Override
    public BigDecimal get() {

        return new BigDecimal("1.1");
    }


}
