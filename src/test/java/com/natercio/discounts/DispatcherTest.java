package com.natercio.discounts;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.natercio.Cart;
import com.natercio.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;

import static com.natercio.ProductFixtures.ONION;
import static com.natercio.ProductFixtures.ONION_FULL_PRICE;
import static com.natercio.ProductFixtures.repeatedProducts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by natercio on 04/07/16.
 */
public class DispatcherTest {

    Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {
        dispatcher = new Dispatcher();
    }

    @Test
    public void testDispatchWithFreeRule() {
        Dispatcher dispatcher = new Dispatcher();

        List<Product> products = Lists.newArrayList(ONION());
        dispatcher.add(new Rule() {
            @Override
            public List<Product> apply(List<Product> products) {
                return products.stream()
                        .map(product -> new Product(product.getName(), 0.0))
                        .collect(Collectors.toList());
            }
        });
        dispatcher.dispatch(products);
        Cart cart = new Cart(dispatcher.dispatch(products));

        assertThat(cart.checkout(), is(0.0));
        assertThat(cart.size(), is(1));
    }

    @Test
    public void testDispatchWithoutRules() {
        Dispatcher dispatcher = new Dispatcher();

        List<Product> products = Lists.newArrayList(ONION());
        dispatcher.dispatch(products);
        Cart cart = new Cart(dispatcher.dispatch(products));

        assertThat(cart.checkout(), is(ONION_FULL_PRICE));
        assertThat(cart.size(), is(1));
        assertThat(cart.get(0), is(ONION()));
    }

    @Test
    public void testDispatchWithEmptyCart() {
        Dispatcher dispatcher = new Dispatcher();

        List<Product> products = Lists.newArrayList();
        Cart cart = new Cart(dispatcher.dispatch(products));

        assertThat(cart.checkout(), is(0.0));
        assertThat(cart.size(), is(0));
    }
}