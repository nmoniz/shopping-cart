package com.natercio;

import junit.framework.TestCase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 29/06/16.
 */
public class CartTest extends TestCase {

    private Cart cart;

    public void setUp() throws Exception {
        cart = new Cart();
        cart.addProduct(new Product("Carrot", 0.50));
        cart.addProduct(new Product("Onion", 0.70));
        cart.addProduct(new Product("Tomato", 1.12));
        cart.addProduct(new Product("Shampoo", 2.49));
    }

    public void testCheckout() throws Exception {
        assertThat(cart.checkout(), is(4.81));
    }

    public void tearDown() throws Exception {

    }

}