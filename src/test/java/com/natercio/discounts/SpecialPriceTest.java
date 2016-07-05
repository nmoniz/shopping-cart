package com.natercio.discounts;

import com.natercio.Cart;
import org.junit.Test;

import java.math.BigDecimal;

import static com.natercio.ProductFixtures.distinctProducts;
import static com.natercio.ProductFixtures.repeatedProducts;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nater on 04/07/2016.
 */
public class SpecialPriceTest extends RuleTestBase {

    @Test
    public void testApplyWithDistinct() throws Exception {
        Cart cart = new Cart(distinctProducts());

        double expectedTotal = getTotal(cart);

        Rule rule = new SpecialPrice(.40, 2, "onion");

        rule.apply(cart);

        assertThat(cart.checkout(), is(expectedTotal));
    }

    @Test
    public void testApplyWithRepeated() throws Exception {
        Cart cart = new Cart(repeatedProducts());

        double expectedTotal = BigDecimal.valueOf(getTotal(cart) - .16).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new SpecialPrice(.40, 2, "onion");

        rule.apply(cart);

        assertThat(cart.checkout(), is(expectedTotal));
    }

}