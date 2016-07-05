package com.natercio.discounts;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.natercio.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by natercio on 02/07/16.
 */
public class DiscountOnCheapest implements Rule {

    Set<String> candidateProductsName;

    private double discount;

    private int requiredQuantity;

    public DiscountOnCheapest(Set<String> candidateProducts, double discount, int requiredQuantity) {
        this.candidateProductsName = candidateProducts;
        this.discount = discount;
        this.requiredQuantity = requiredQuantity;
    }

    @Override
    public void apply(List<Product> products) {
        List<Product> candidates = Lists.newArrayList();

        candidates = getCandidates(products);

        for (int i = 0; i < candidates.size() / requiredQuantity; i++)
            candidates.get(i).setModifier(discount);
    }

    private List<Product> getCandidates(List<Product> products) {
        return products.stream()
                .filter(product -> candidateProductsName.contains(product.getName()))
                .sorted((p1, p2) -> {
                    double difference = p1.getPrice() - p2.getPrice();

                    if (difference == 0.0) return 0;

                    return BigDecimal.valueOf(difference).divide(BigDecimal.valueOf(Math.abs(difference))).intValue();
                })
                .collect(Collectors.toList());
    }

}
