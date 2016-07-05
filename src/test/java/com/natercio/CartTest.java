package com.natercio;

import org.junit.Test;

import static com.natercio.ProductFixtures.discountedProducts;
import static com.natercio.ProductFixtures.repeatedProducts;

/**
 * Created by natercio on 29/06/16.
 */
public class CartTest {

    @Test
    public void testCheckoutWithDiscounts() {
        Cart cart = new Cart(discountedProducts());

        
    }

    @Test
    public void testCheckoutWithoutDiscounts() {
        Cart cart = new Cart(repeatedProducts());


    }

}