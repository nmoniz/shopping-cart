package com.natercio;

import com.google.common.collect.Lists;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.util.List;

/**
 * Created by nater on 04/07/2016.
 */
public class ProductFixtures {

    public static List<Product> repeatedProducts() {
        return Lists.newArrayList(
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("carrot", 0.66),
                new Product("carrot", 0.66),
                new Product("potato", 0.39),
                new Product("potato", 0.39),
                new Product("potato", 0.39),
                new Product("melon", 1.95),
                new Product("melon", 1.95),
                new Product("melon", 1.95),
                new Product("melon", 1.95),
                new Product("melon", 1.95)
        );
    }

    public static List<Product> distinctProducts() {
        return Lists.newArrayList(
                new Product("onion", 0.44),
                new Product("carrot", 0.66),
                new Product("potato", 0.39),
                new Product("melon", 1.95),
                new Product("water melon", 1.39),
                new Product("nuts", 4.95)
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
        )
    }
}
