package com.natercio.discounts;

import com.natercio.Cart;

import java.math.BigDecimal;

/**
 * Created by nater on 04/07/2016.
 */
public class RuleTestBase {

    protected double getTotal(Cart cart) {
        return BigDecimal.valueOf(cart.stream()
                .mapToDouble(p -> p.getPrice())
                .sum())
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
}
