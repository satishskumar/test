package com.capgemini.test.shopping.model;

import java.math.BigDecimal;

/**
 * Created by satish on 27/06/16.
 */
public abstract class Product {

    protected BigDecimal price;

    public BigDecimal getPrice(){
        return price;
    }
}
