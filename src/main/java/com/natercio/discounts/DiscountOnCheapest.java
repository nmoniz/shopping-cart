package com.natercio.discounts;

import com.google.common.collect.Lists;
import com.natercio.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class DiscountOnCheapest extends GroupingRule {

    private Set<String> candidateProductsName;

    private double discount;

    private int requiredQuantity;

    public DiscountOnCheapest(Set<String> candidateProducts, double discount, int requiredQuantity) {
        this.candidateProductsName = candidateProducts;
        this.discount = discount;
        this.requiredQuantity = requiredQuantity;
    }

    @Override
    protected Product transform(Product product) {
        final double modDiff = product.getModifier() - 1.0;

        return new Product(
                product.getName(),
                product.getPrice(),
                discount + modDiff);
    }

    @Override
    protected List<Product> candidates(List<Product> products) {
        List<Product> temp = products.stream()
                .filter(product -> candidateProductsName.contains(product.getName()))
                .sorted((p1, p2) -> {
                    double difference = p1.getPrice() - p2.getPrice();

                    if (difference == 0.0) return 0;

                    return BigDecimal.valueOf(difference).divide(BigDecimal.valueOf(Math.abs(difference))).intValue();
                })
                .collect(Collectors.toList());

        return temp.stream()
                .limit(temp.size() / requiredQuantity)
                .collect(Collectors.toList());
    }

}
