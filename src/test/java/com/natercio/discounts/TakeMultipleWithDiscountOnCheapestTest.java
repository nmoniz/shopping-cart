package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
import com.natercio.Cart;
import org.junit.Test;

import java.math.BigDecimal;

import static com.natercio.Fixtures.distinctProducts;
import static com.natercio.Fixtures.repeatedProducts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 03/07/16.
 */
public class TakeMultipleWithDiscountOnCheapestTest extends RuleTestBase {

    @Test
    public void testApplyWithDistinct() throws Exception {
        Cart cart = new Cart(distinctProducts());

        double total = getTotal(cart);

        Rule rule = new TakeMultipleWithDiscountOnCheapest(ImmutableSet.of("onion", "carrot"), 0.0, 3);

        rule.apply(cart);

        assertThat(cart.checkout(), is(total));
    }

    @Test
    public void testApplyWithRepeated() throws Exception {
        Cart cart = new Cart(repeatedProducts());

        double total = BigDecimal.valueOf(getTotal(cart) - .88).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new TakeMultipleWithDiscountOnCheapest(ImmutableSet.of("onion", "carrot"), 0.0, 3);

        rule.apply(cart);

        assertThat(cart.checkout(), is(total));
    }

}