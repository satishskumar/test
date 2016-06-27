package com.capgemini.test.shopping.service;

import com.capgemini.test.shopping.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by avni on 27/06/16.
 */
public class PriceCalculatorService {

    public BigDecimal getTotalPrice(List<Product> products) {
        BigDecimal totalPrice = products.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getPrice() != null)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice;
    }
}
