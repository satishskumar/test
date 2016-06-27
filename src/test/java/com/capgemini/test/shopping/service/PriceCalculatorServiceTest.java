package com.capgemini.test.shopping.service;

import com.capgemini.test.shopping.model.Apple;
import com.capgemini.test.shopping.model.Orange;
import com.capgemini.test.shopping.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by avni on 27/06/16.
 */
public class PriceCalculatorServiceTest {

    PriceCalculatorService testObj;

    @Before
    public void setUp() {
        testObj = new PriceCalculatorService();
    }

    @Test
    public void testGetTotalPrice_When_No_ProductProvided() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();

        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getTotalPrice(arbitraryProducts)));
    }


    @Test
    public void testGetTotalPrice_When_OnlyOneProductProvided() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());


        assertEquals(0, new Apple().getPrice().compareTo(testObj.getTotalPrice(arbitraryProducts)));
    }

    @Test
    public void testGetTotalPrice_When_MultipleProductProvided() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());


        BigDecimal expectedValue = new BigDecimal(BigInteger.ZERO);
        expectedValue = expectedValue.add(new Apple().getPrice().multiply(new BigDecimal(2.0)));
        expectedValue = expectedValue.add(new Orange().getPrice().multiply(new BigDecimal(2.0)));


        assertEquals(0, expectedValue.compareTo(testObj.getTotalPrice(arbitraryProducts)));
    }

    @Test
    public void testGetTotalPrice_When_MultipleProductProvided_Having_One_Null_Product() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());


        BigDecimal expectedValue = new BigDecimal(BigInteger.ZERO);
        expectedValue = expectedValue.add(new Apple().getPrice().multiply(new BigDecimal(2.0)));
        expectedValue = expectedValue.add(new Orange().getPrice().multiply(new BigDecimal(2.0)));


        assertEquals(0, expectedValue.compareTo(testObj.getTotalPrice(arbitraryProducts)));
    }
}