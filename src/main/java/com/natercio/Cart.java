package com.natercio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by natercio on 29/06/16.
 */
public class Cart extends ArrayList<Product> {

    public Cart() {
        super();
    }

    public Cart(Collection<? extends Product> collection) {
        super(collection);
    }

    public double checkout() {
        BigDecimal total = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);

        for (Product product : this) {
            total = total.add(BigDecimal.valueOf(product.getValue()));
        }

        return total.doubleValue();
    }

}
