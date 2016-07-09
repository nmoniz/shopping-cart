package com.natercio.discounts;

import com.natercio.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by natercio on 30/06/16.
 */
public class DiscountOnLast extends GroupingRule {

    private double discount;

    private int requiredQuantity;

    private String productName;

    public DiscountOnLast(double discount, int requiredQuantity, String productName) {
        this.discount = discount;
        this.requiredQuantity = requiredQuantity;
        this.productName = productName;
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
        final List<Product> temp = getCandidates(products);

        return temp.stream()
                .limit(temp.size() / requiredQuantity)
                .collect(Collectors.toList());
    }

    private List<Product> getCandidates(List<Product> products) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());
    }

}
