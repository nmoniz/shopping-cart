package com.natercio;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

public class Product {

    private String name;

    private BigDecimal price;

    private double modifier;

    public Product(String name, double price) {
        init(name, price, 1.0);
    }


    public Product(String name, double price, double modifier) {
        init(name, price, modifier);
    }

    private void init(String name, double price, double modifier) {
        checkArgument(price >= 0.0);
        checkArgument(modifier >= 0.0);

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
        checkArgument(price >= 0.0);

        this.price = BigDecimal.valueOf(price);
    }

    public double getModifier() {
        return modifier;
    }

    public void setModifier(double modifier) {
        checkArgument(modifier >= 0.0);

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

    @Override
    public Product clone() {
        return new Product(
                this.getName(),
                this.getPrice(),
                this.getModifier()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;

        if (obj instanceof Product) {
            Product p = (Product) obj;

            return this.getName().equals(this.name) &&
                    this.getPrice() == p.getPrice() &&
                    this.getModifier() == p.getModifier();
        }

        return false;
    }
}
