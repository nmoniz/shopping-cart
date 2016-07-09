package com.natercio.discounts;

import com.natercio.Cart;
import com.natercio.Product;
import org.jooq.lambda.Seq;

import java.io.SequenceInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Dispatcher extends HashSet<Rule> {

    public List<Product> dispatch(List<Product> products) {
        return Seq.ofType(this.stream(), Rule.class).foldLeft(products, (productsAccu, rule) -> rule.apply(productsAccu));
    }
}
