package com.natercio.discounts;

import com.natercio.Product;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by natercio on 30/06/16.
 */
public class TakeMultipleWithDiscountOnLastTest extends TestCase {

    List<Product> products;

    public void setUp() throws Exception {
        super.setUp();

    }

    public void testApply() throws Exception {
        Rule take3pay2 = new TakeMultipleWithDiscountOnLast(0.0, 3);
    }

}