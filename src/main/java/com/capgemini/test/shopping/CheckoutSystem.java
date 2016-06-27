package com.capgemini.test.shopping;

import com.capgemini.test.shopping.model.Product;
import com.capgemini.test.shopping.service.DiscountCalculatorService;
import com.capgemini.test.shopping.service.PriceCalculatorService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by avni on 27/06/16.
 */
public class CheckoutSystem {

    private PriceCalculatorService priceCalculatorService;

    private DiscountCalculatorService discountCalculatorService;

    public CheckoutSystem() {

        priceCalculatorService = new PriceCalculatorService();

        discountCalculatorService = new DiscountCalculatorService();

    }

    public BigDecimal checkout(List<Product> products) {
        return priceCalculatorService.getTotalPrice(products).subtract(discountCalculatorService.getDiscount(products));
    }
}
