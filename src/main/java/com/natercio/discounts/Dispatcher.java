package com.natercio.discounts;

import com.natercio.Cart;
import com.natercio.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by natercio on 29/06/16.
 */
public abstract class Dispatcher extends HashSet<Rule> {

    public void process(List<Product> cart) {
        this.stream().forEach(rule -> {
            rule.apply(cart);
        });
    }
}
