package com.natercio.discounts;

import com.natercio.Product;

import java.util.List;

/**
 * Created by natercio on 29/06/16.
 */
public interface Rule {

    void apply(List<Product> products);

}
