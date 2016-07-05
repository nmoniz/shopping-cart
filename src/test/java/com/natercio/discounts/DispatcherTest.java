package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
import com.natercio.Cart;
import org.junit.Test;

import static com.natercio.ProductFixtures.repeatedProducts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by natercio on 04/07/16.
 */
public class DispatcherTest {

    @Test
    public void testDispatchNoDiscount() throws Exception {
        Dispatcher dispatcher = new Dispatcher();

        dispatcher.add(new DiscountOnCheapest(ImmutableSet.of("not-a-product"), 0.0, 2));
        dispatcher.add(new DiscountOnLast(0.0, 2, "not-a-product"));
        dispatcher.add(new SpecialPrice(0.0, 2, "not-a-product"));

        Cart products = new Cart(repeatedProducts());
        double valueBeforeDispatch = products.checkout();
        dispatcher.dispatch(products);

        assertThat(products.checkout(), is(valueBeforeDispatch));
    }

    @Test
    public void testDispatchWithNoProducts() throws Exception {
        Dispatcher dispatcher = new Dispatcher();

        dispatcher.add(new DiscountOnCheapest(ImmutableSet.of("not-a-product"), 0.0, 2));
        dispatcher.add(new DiscountOnLast(0.0, 2, "not-a-product"));
        dispatcher.add(new SpecialPrice(0.0, 2, "not-a-product"));

        Cart products = new Cart(repeatedProducts());
        double valueBeforeDispatch = products.checkout();
        dispatcher.dispatch(products);

        assertThat(products.checkout(), is(valueBeforeDispatch));
    }
}