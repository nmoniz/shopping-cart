package com.natercio.discounts;

import com.natercio.Cart;
import com.natercio.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.natercio.ProductFixtures.distinctProducts;
import static com.natercio.ProductFixtures.repeatedProducts;
import static com.natercio.discounts.RuleTestUtils.getTotalFullPrice;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nater on 04/07/2016.
 */
public class SpecialPriceTest {

    @Test
    public void testApplyShouldReturnFullPrice() throws Exception {
        List<Product> products = repeatedProducts();

        double expectedTotal = getTotalFullPrice(products);

        Rule rule = new SpecialPrice(.40, 2, "onion");

        Cart cart = new Cart(rule.apply(products));

        assertThat(cart.checkout(), is(expectedTotal));
    }

    @Test
    public void testApplyShouldReturnDiscounts() throws Exception {
        List<Product> products = repeatedProducts();

        double expectedTotal = BigDecimal.valueOf(getTotalFullPrice(products) - .6).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new SpecialPrice(.1, 2, "onion");

        Cart cart = new Cart(rule.apply(products));

        assertThat(cart.checkout(), is(expectedTotal));
    }

}