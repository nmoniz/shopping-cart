package com.natercio.discounts;

import com.google.common.collect.Lists;
import com.natercio.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpecialPrice extends GroupingRule {

    private BigDecimal price;

    private int requiredQuantity;

    private String productName;

    public SpecialPrice(double price, int requiredQuantity, String productName) {
        this.price = BigDecimal.valueOf(price);
        this.requiredQuantity = requiredQuantity;
        this.productName = productName;
    }

    @Override
    protected Product transform(Product product) {
        return new Product(
                product.getName(),
                price.doubleValue(),
                product.getModifier());
    }

    @Override
    protected List<Product> candidates(List<Product> products) {
        List<Product> temp = products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());

        return temp.stream()
                .limit(temp.size() - (temp.size() % requiredQuantity))
                .collect(Collectors.toList());
    }
}
