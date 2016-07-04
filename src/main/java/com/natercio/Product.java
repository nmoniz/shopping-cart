package com.natercio;

import java.math.BigDecimal;

/**
 * Created by natercio on 29/06/16.
 */
public class Product {

    private String name;

    private BigDecimal price;

    private double modifier;

    public Product(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.modifier = 1.0;
    }


    public Product(String name, double price, double modifier) {
        this.name = name;
        this.price = BigDecimal.valueOf(price).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price.doubleValue();
    }

    public void setPrice(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public double getModifier() {
        return modifier;
    }

    public void setModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getValue() {
        return this.price.multiply(BigDecimal.valueOf(this.modifier)).doubleValue();
    }

    @Override
    public String toString() {
        String result = this.name + " >>> " + price;

        if (this.modifier != 1.0) {
            double value = getValue();
            result += " (" + ((this.modifier < 1.0) ? "-" : "+") + this.price.subtract(BigDecimal.valueOf(value)) + ") = " + value;
        }

        return result;
    }

}
