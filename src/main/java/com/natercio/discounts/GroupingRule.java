package com.natercio.discounts;

import com.natercio.Product;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GroupingRule implements Rule {

    @Override
    public List<Product> apply(List<Product> products) {
        List<Product> candidates = candidates(products);

        return products.stream()
                .map(product -> {
                    if (candidates.contains(product)) {
                        candidates.remove(product);
                        return transform(product);
                    } else {
                        return product.clone();
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * @param product Product to transform
     * @return this should return a transformed product
     */
    protected abstract Product transform(Product product);

    /**
     * @param products list of products to search
     * @return the list of products that should be transformed
     */
    protected abstract List<Product> candidates(List<Product> products);
}
