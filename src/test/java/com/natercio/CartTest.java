package com.natercio;

import com.google.common.collect.Lists;
import org.junit.Test;

import static com.natercio.ProductFixtures.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 29/06/16.
 */
public class CartTest {

    @Test
    public void testCheckoutWithDiscounts() {
        Cart cart = new Cart(Lists.newArrayList(POTATO(), POTATO(), ONION()));

        double expectedPrice = POTATO_DISCOUNT_PRICE * 2 + ONION_DISCOUNT_PRICE;

        assertThat(cart.checkout(), is(expectedPrice));
    }

    @Test
    public void testCheckoutWithoutDiscounts() {
        Cart cart = new Cart(Lists.newArrayList(ONION(), ONION(), ONION()));

        double expectedPrice = ONION_DISCOUNT_PRICE * 3;

        assertThat(cart.checkout(), is(expectedPrice));
    }

    @Test
    public void testCheckoutWithEmptyCart() {
        Cart cart = new Cart();

        assertThat(cart.checkout(), is(0.00));
    }

}