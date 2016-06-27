package com.capgemini.test.shopping.service;

import com.capgemini.test.shopping.model.Apple;
import com.capgemini.test.shopping.model.Orange;
import com.capgemini.test.shopping.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by avni on 27/06/16.
 */
public class DiscountCalculatorServiceTest {


    DiscountCalculatorService testObj;

    @Before
    public void setUp() {
        testObj = new DiscountCalculatorService();
    }

    @Test
    public void testGetDiscountPrice_On_Both() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());

        assertEquals(0, new Orange().getPrice().add(new Apple().getPrice()).compareTo(testObj.getDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetDiscountPrice_On_Apple() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());

        assertEquals(0, new Apple().getPrice().compareTo(testObj.getDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetDiscountPrice_On_Orange() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());

        assertEquals(0, new Orange().getPrice().compareTo(testObj.getDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetAppleDiscount_When_0_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Orange());


        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getAppleDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetAppleDiscount_When_1_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());

        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getAppleDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetAppleDiscount_When_2_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());

        assertEquals(0, new Apple().getPrice().compareTo(testObj.getAppleDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetAppleDiscount_When_3_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());

        assertEquals(0, new Apple().getPrice().compareTo(testObj.getAppleDiscount(arbitraryProducts)));


    }

    @Test
    public void testGetAppleDiscount_When_4_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Apple());

        assertEquals(0, new Apple().getPrice().multiply(new BigDecimal(2.0)).compareTo(testObj.getAppleDiscount(arbitraryProducts)));

    }


    @Test
    public void testGetOrangeDiscount_When_0_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());


        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getOrangeDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetOrangeDiscount_When_1_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());

        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getOrangeDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetOrangeDiscount_When_2_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());

        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.getOrangeDiscount(arbitraryProducts)));

    }

    @Test
    public void testGetOrangeDiscount_When_3_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Apple());

        assertEquals(0, new Orange().getPrice().compareTo(testObj.getOrangeDiscount(arbitraryProducts)));


    }

    @Test
    public void testGetOrangeDiscount_When_4_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(null);
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());

        assertEquals(0, new Orange().getPrice().compareTo(testObj.getOrangeDiscount(arbitraryProducts)));

    }
}