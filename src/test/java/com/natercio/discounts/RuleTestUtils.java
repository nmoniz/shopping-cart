package com.natercio.discounts;

import com.natercio.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by nater on 04/07/2016.
 */
public class RuleTestUtils {

    public static double getTotalFullPrice(List<Product> products) {
        return products.stream()
                .map(p -> BigDecimal.valueOf(
                        p.getPrice()))
                .reduce(
                        BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP),
                        BigDecimal::add)
            .doubleValue();
    }
}
