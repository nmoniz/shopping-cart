package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
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
 * Created by natercio on 03/07/16.
 */
public class DiscountOnCheapestTest {

    @Test
    public void testApplyShouldReturnFullPrice() {
        List<Product> products = distinctProducts();

        double total = getTotalFullPrice(products);

        Rule rule = new DiscountOnCheapest(ImmutableSet.of("onion", "carrot"), 0.0, 3);

        Cart cart = new Cart(rule.apply(products));

        assertThat(cart.checkout(), is(total));
    }

    @Test
    public void testApplyShouldReturnDicounts() {
        List<Product> products = repeatedProducts();

        double totalWithDiscount = BigDecimal.valueOf(getTotalFullPrice(products) - .5).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        Rule rule = new DiscountOnCheapest(ImmutableSet.of("onion", "carrot"), 0.0, 3);

        Cart finalCart = new Cart(rule.apply(products));

        assertThat(finalCart.checkout(), is(totalWithDiscount));
    }

}