package com.natercio.discounts;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.natercio.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by natercio on 30/06/16.
 */
public class TakeMultipleWithDiscountOnLast implements Rule {

    private double discount;

    private int requiredQuantity;

    private String productName;

    public TakeMultipleWithDiscountOnLast(double discount, int requiredQuantity, String productName) {
        this.discount = discount;
        this.requiredQuantity = requiredQuantity;
        this.productName = productName;
    }

    @Override
    public void apply(List<Product> products) {
        int count = 0;

        List<Product> candidates = products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());

        for (int i = 0; i < candidates.size() / requiredQuantity; i++)
            candidates.get(i).setModifier(discount);
    }

}
