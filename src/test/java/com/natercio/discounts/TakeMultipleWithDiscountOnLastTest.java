package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
import com.natercio.Cart;
import com.natercio.Product;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.natercio.Fixtures.distinctProducts;
import static com.natercio.Fixtures.repeatedProducts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 30/06/16.
 */
public class TakeMultipleWithDiscountOnLastTest extends RuleTestBase {

    @Test
    public void testApplyWithDistinct() throws Exception {
        Cart cart = new Cart(distinctProducts());

        double expectedTotal = getTotal(cart);

        Rule rule = new TakeMultipleWithDiscountOnLast(0.0, 3, "carrot");

        rule.apply(cart);

        assertThat(cart.checkout(), is(expectedTotal));
    }

    @Test
    public void testApplyWithRepeated() throws Exception {
        Cart cart = new Cart(repeatedProducts());

        double expectedTotal = BigDecimal.valueOf(getTotal(cart) - .88).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new TakeMultipleWithDiscountOnLast(0.0, 3, "carrot");

        rule.apply(cart);

        assertThat(cart.checkout(), is(expectedTotal));
    }

}