package com.capgemini.test.shopping.model;

import java.math.BigDecimal;

/**
 * Created by avni on 27/06/16.
 */
public class Apple extends Product{
    public Apple(){
        super();
        price = new BigDecimal(0.60);
    }
}