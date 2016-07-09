package com.natercio;

import com.google.common.collect.Lists;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Created by nater on 04/07/2016.
 */
public class ProductFixtures {

    public static String[] PRODUCT_NAMES = {"onion", "carrot", "potato", "melon"};

    public static Product ONION() {
        return new Product(
                "onion",
                0.45);
    }

    public static double ONION_FULL_PRICE = 0.45;

    public static double ONION_DISCOUNT_PRICE = 0.45;

    public static Product POTATO() {
        return new Product(
                "potato",
                0.8,
                0.9
        );
    }

    public static double POTATO_FULL_PRICE = 0.8;

    public static double POTATO_DISCOUNT_PRICE = 0.72;

    public static List<Product> repeatedProducts() {
        return Lists.newArrayList(
                new Product("onion", 0.25),
                new Product("onion", 0.25),
                new Product("onion", 0.25),
                new Product("onion", 0.25),
                new Product("carrot", 0.75),
                new Product("carrot", 0.75),
                new Product("potato", 0.50),
                new Product("potato", 0.50),
                new Product("potato", 0.50),
                new Product("melon", 1.20),
                new Product("melon", 1.20),
                new Product("melon", 1.20),
                new Product("melon", 1.20),
                new Product("melon", 1.20)
        );
    }

    public static List<Product> distinctProducts() {
        return Lists.newArrayList(
                new Product("onion", 0.5),
                new Product("carrot", 0.75),
                new Product("potato", 0.80),
                new Product("melon", 2.95),
                new Product("water melon", 1.33),
                new Product("nuts", 3.67)
        );
    }



    public static List<Product> discountedProducts() {
        return Lists.newArrayList(
                new Product("onion", 0.44, 0.5),
                new Product("carrot", 0.66, 0.44),
                new Product("potato", 0.39, 0.66),
                new Product("melon", 1.95, 0.0),
                new Product("water melon", 1.39, 0.01),
                new Product("nuts", 4.95, 0.99)
        );
    }
}
