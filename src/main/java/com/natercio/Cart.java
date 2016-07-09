package com.natercio;

import org.jooq.lambda.Seq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Cart extends ArrayList<Product> {

    public Cart() {
        super();
    }

    public Cart(Collection<? extends Product> collection) {
        super(collection);
    }

    public double checkout() {
        return this.stream()
                .map(product -> BigDecimal.valueOf(product.getValue()))
                .reduce(
                        BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP),
                        BigDecimal::add)
                .doubleValue();
    }

    public String getReceipt() {
        return Seq.ofType(this.stream(), Product.class)
                .foldLeft("", (s, product) -> s += product.toString() + "\n");
    }

}
