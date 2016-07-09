package com.natercio;

import junit.framework.TestCase;
import org.junit.Test;

import static com.natercio.ProductFixtures.ONION;
import static com.natercio.ProductFixtures.POTATO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by natercio on 29/06/16.
 */
public class ProductTest {

    Product noDiscountProduct = new Product("Onion", 0.25d);
    Product discountedProduct = new Product("Beer", 0.50d, 0.9d);

    @Test
    public void testToString() {
        assertThat(noDiscountProduct.toString(), containsString("Onion"));
        assertThat(noDiscountProduct.toString(), containsString("0.25"));

        assertThat(discountedProduct.toString(), containsString("Beer"));
        assertThat(discountedProduct.toString(), containsString("0.45"));
        assertThat(discountedProduct.toString(), containsString("0.50"));
    }

    @Test
    public void testGetValue() {
        assertThat(noDiscountProduct.getValue(), is(0.25));
        assertThat(discountedProduct.getValue(), is(0.45));
    }

    @Test(expected = IllegalArgumentException.class )
    public void testNegativePriceConstructor() {
        Product p = new Product("dummy", -1.0);
    }

    @Test(expected = IllegalArgumentException.class )
    public void testNegativePriceSet() {
        Product p = new Product("dummy", 1.0);
        p.setPrice(-1.0);
    }

    @Test(expected = IllegalArgumentException.class )
    public void testNegativeModifierConstructor() {
        Product p = new Product("dummy", 1.0, -0.5);
    }

    @Test(expected = IllegalArgumentException.class )
    public void testNegativeModifierSet() {
        Product p = new Product("dummy", 1.0);
        p.setModifier(-1.0);
    }

    @Test
    public void testClone() {
        Product onion = ONION();
        Product cloned = onion.clone();

        assertThat(onion.getName(), is(cloned.getName()));
        assertThat(onion.getPrice(), is(cloned.getPrice()));
        assertThat(onion.getModifier(), is(cloned.getModifier()));
    }

    @Test
    public void testEquals() {
        Product onion1 = ONION();
        Product onion2 = ONION();
        Product potato = POTATO();
        Object obj = ONION();

        assertThat(onion1.equals(onion2), is(true));
        assertThat(onion1.equals(obj), is(true));
        assertThat(onion1.equals(potato), is(false));
    }
}