package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.natercio.Cart;
import com.natercio.Product;
import junit.framework.TestCase;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 03/07/16.
 */
public class TakeMultipleWithDiscountOnCheapestTest extends TestCase {

    List<Product> products;

    Cart cart;

    public void setUp() throws Exception {
        super.setUp();


        cart = new Cart(Lists.newArrayList(
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("onion", 0.44),
                new Product("carrot", 0.66),
                new Product("carrot", 0.66),
                new Product("potatoe", 0.39),
                new Product("potatoe", 0.39),
                new Product("potatoe", 0.39),
                new Product("melon", 1.95),
                new Product("melon", 1.95)
        ));
    }

    public void testApply() throws Exception {
        Rule rule = new TakeMultipleWithDiscountOnCheapest(ImmutableSet.of("onion", "carrot"), 0.0, 3);

        rule.apply(cart);

        assertThat(cart.checkout(), is(7.27));
    }

}