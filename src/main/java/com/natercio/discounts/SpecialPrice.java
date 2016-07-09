package com.natercio.discounts;

import com.natercio.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
        final List<Product> temp = getAllCandidates(products);

        return temp.stream()
                .limit(temp.size() - (temp.size() % requiredQuantity))
                .collect(Collectors.toList());
    }

    private List<Product> getAllCandidates(List<Product> products) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .collect(Collectors.toList());
    }
}
