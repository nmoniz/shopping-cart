package com.natercio;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by natercio on 29/06/16.
 */
public class Cart {

    List<Product> products;

    public Cart() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double checkout() {
        double total = 0;

        for (Product product : products) {
            total += product.price;
        }

        return Math.round(total*100)/100d;
    }

}
