package com.natercio.discounts;

import com.natercio.Product;

import java.util.List;

public interface Rule {

    List<Product> apply(List<Product> products);

}
