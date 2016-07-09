package com.natercio.discounts;

import com.natercio.Cart;
import com.natercio.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.natercio.ProductFixtures.distinctProducts;
import static com.natercio.ProductFixtures.repeatedProducts;
import static com.natercio.discounts.RuleTestUtils.getTotalFullPrice;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 30/06/16.
 */
public class DiscountOnLastTest {

    @Test
    public void testApplyShouldReturnFullPrice() {
        List<Product> products = distinctProducts();

        double expectedTotal = getTotalFullPrice(products);

        Rule rule = new DiscountOnLast(0.0, 3, "carrot");

        Cart cart = new Cart(rule.apply(products));

        assertThat(cart.checkout(), is(expectedTotal));
    }

    @Test
    public void testApplyShouldReturnDiscounts() {
        List<Product> products = repeatedProducts();

        double expectedTotal = BigDecimal.valueOf(getTotalFullPrice(products) - .25).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new DiscountOnLast(0.0, 3, "onion");

        Cart cart = new Cart(rule.apply(products));

        assertThat(cart.checkout(), is(expectedTotal));
    }

}