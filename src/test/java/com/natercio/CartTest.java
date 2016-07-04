package com.natercio;

import com.google.common.collect.Lists;
import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

/**
 * Created by natercio on 29/06/16.
 */
public class CartTest extends TestCase {

    private Cart cart;

    public void setUp() throws Exception {
        cart = new Cart(Lists.newArrayList(
                new Product("onion", 0.44),
                new Product("carrot", 0.66, 0.5),
                new Product("carrot", 0.66, 0.5),
                new Product("potatoe", 0.39)
        ));
    }

    public void testCheckout() throws Exception {
        assertThat(cart.checkout(), is(1.49));
    }

}