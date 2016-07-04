package com.natercio;

import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by natercio on 29/06/16.
 */
public class ProductTest extends TestCase {

    Product noDiscountProduct = new Product("Onion", 0.25d);
    Product discountedProduct = new Product("Beer", 0.50d, 0.9d);

    public void testToString() throws Exception {
        assertThat(noDiscountProduct.toString(), containsString("Onion"));
        assertThat(noDiscountProduct.toString(), containsString("0.25"));

        assertThat(discountedProduct.toString(), containsString("Beer"));
        assertThat(discountedProduct.toString(), containsString("0.45"));
        assertThat(discountedProduct.toString(), containsString("0.50"));
    }

    public void testGetValue() throws Exception {
        assertThat(noDiscountProduct.getValue(), is(0.25));
        assertThat(discountedProduct.getValue(), is(0.45));
    }
}