package com.capgemini.test.shopping;

import com.capgemini.test.shopping.model.Apple;
import com.capgemini.test.shopping.model.Orange;
import com.capgemini.test.shopping.model.Product;
import com.capgemini.test.shopping.service.DiscountCalculatorService;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by satish on 27/06/16.
 */
public class CheckoutSystemTest {

    CheckoutSystem testObj;

    @Before
    public void setUp() {
        testObj = new CheckoutSystem();
    }

    @Test
    public void testCheckout_With_No_Item() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();

        assertEquals(0, BigDecimal.ZERO.compareTo(testObj.checkout(arbitraryProducts)));
    }

    @Test
    public void testCheckout_With_One_Apple() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());


        assertEquals(0, new Apple().getPrice().compareTo(testObj.checkout(arbitraryProducts)));
    }

    @Test
    public void testCheckout_With_Two_Apple() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Apple());


        assertEquals(0, new Apple().getPrice().compareTo(testObj.checkout(arbitraryProducts)));
    }


    @Test
    public void testCheckout_With_Two_Apple_Two_Oranges() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());


        assertEquals(0, new Apple().getPrice().add(new Orange().getPrice().add(new Orange().getPrice())).compareTo(testObj.checkout(arbitraryProducts)));
    }

    @Test
    public void testCheckout_With_Two_Apple_Three_Oranges() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Apple());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());


        assertEquals(0, new Apple().getPrice().add(new Orange().getPrice().add(new Orange().getPrice())).compareTo(testObj.checkout(arbitraryProducts)));
    }



    @Test
    public void testCheckout_With_Three_Oranges() throws Exception {

        List<Product> arbitraryProducts = new ArrayList<Product>();
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());
        arbitraryProducts.add(new Orange());


        assertEquals(0, new Orange().getPrice().add(new Orange().getPrice()).compareTo(testObj.checkout(arbitraryProducts)));
    }
}