package com.natercio.discounts;

import com.google.common.base.Optional;
import com.natercio.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by natercio on 30/06/16.
 */
public class TakeMultipleWithDiscountOnLast implements Rule {

    private double discount;

    private int requiredQuantity;

    public TakeMultipleWithDiscountOnLast(double discount, int quantity) {
        this.discount = discount;
        this.requiredQuantity = quantity;
    }

    @Override
    public void apply(List<Product> products) {
        Map<String, Integer> quantities = new HashMap<String, Integer>();

        products.stream()
                .forEach(product -> {
                    Integer quantity = Optional.fromNullable(quantities.get(product.getName())).or(0);

                    quantity++;

                    if (quantity % this.requiredQuantity == 0) product.setModifier(this.discount);

                    quantities.put(product.getName(), quantity);
                });
    }

}
