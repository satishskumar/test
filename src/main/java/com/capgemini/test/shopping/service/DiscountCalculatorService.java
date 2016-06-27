package com.capgemini.test.shopping.service;

import com.capgemini.test.shopping.model.Apple;
import com.capgemini.test.shopping.model.Orange;
import com.capgemini.test.shopping.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by avni on 27/06/16.
 */
public class DiscountCalculatorService {

    public BigDecimal getDiscount(List<Product> products) {
        return getAppleDiscount(products).add(getOrangeDiscount(products));
    }

    BigDecimal getAppleDiscount(List<Product> products) {
        List<Product> productHavingTypeApple = filterProductsBasedOnType(products,Apple.class);
        if (null == productHavingTypeApple) {
            return new BigDecimal(0.00);
        }

        return getOfferBuy1Get1(productHavingTypeApple);
    }



    BigDecimal getOrangeDiscount(List<Product> products) {
        List<Product> productHavingTypeOrange =filterProductsBasedOnType(products,Orange.class);

        if (null == productHavingTypeOrange) {
            return new BigDecimal(0.00);
        }

        return getOfferBuy3For2(productHavingTypeOrange);
    }


    private BigDecimal getOfferBuy1Get1(List<Product> products) {
        int numberOfItems = products.size();
        BigDecimal priceOfSingleItem = getPriceOfSingleItem(products);

        BigDecimal discount= priceOfSingleItem.multiply(new BigDecimal(Math.floor(numberOfItems / 2)));
        return discount;
    }

    private BigDecimal getPriceOfSingleItem(List<Product> products) {
        return products.get(0).getPrice();
    }

    private BigDecimal getOfferBuy3For2(List<Product> products) {
        int numberOfOranges = products.size();
        BigDecimal priceOfSingleItem = getPriceOfSingleItem(products);
        BigDecimal discount = priceOfSingleItem.multiply(new BigDecimal(( Math.floor(numberOfOranges/3))));

        return discount;
    }
    private List<Product> filterProductsBasedOnType(List<Product> products, Class Class) {
        return products.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getPrice() != null)
                .collect(groupingBy(p -> p.getClass()))
                .get(Class);
    }
}
