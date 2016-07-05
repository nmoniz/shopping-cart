package com.natercio.discounts;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.natercio.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by natercio on 02/07/16.
 */
public class SpecialPrice implements Rule {

    private BigDecimal price;

    private int requiredQuantity;

    private String productName;

    public SpecialPrice(double price, int requiredQuantity, String productName) {
        this.price = BigDecimal.valueOf(price);
        this.requiredQuantity = requiredQuantity;
        this.productName = productName;
    }

    @Override
    public void apply(List<Product> products) {
        List<Product> repeated = Lists.newArrayList();

        products.stream()
                .filter(product -> product.getName().equals(productName))
                .forEach(product -> {
                    repeated.add(product);

                    if (repeated.size() % this.requiredQuantity == 0) {
                        repeated.stream().forEach(repProduct -> {
                            repProduct.setPrice(price.doubleValue());
                        });
                        repeated.clear();
                    }
                });
    }
}
