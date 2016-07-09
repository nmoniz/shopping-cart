package com.natercio;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.natercio.discounts.DiscountOnCheapest;
import com.natercio.discounts.DiscountOnLast;
import com.natercio.discounts.Dispatcher;
import com.natercio.discounts.SpecialPrice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Application {

    private enum State {
        MAIN,
        PRODUCTS,
        RULES,
        CHECKOUT
    }

    /**
     * Just a small console application to test this
     */
    public static void main(String[] args) throws IOException {
        State state = State.MAIN;
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Cart cart = new Cart(Lists.newArrayList());
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("Hello dear customer, welcome to the 'sorry for the being late' store?");
        System.out.println("=== TODAY SPECIALS ===");
        System.out.println(" * take 5 yogurts and pay 1€ * ");
        System.out.println(" * take 3 pizzas and pay 2 ");
        System.out.println(" * take any 4 ice creams and the cheapest is free * ");

        dispatcher.add(new DiscountOnCheapest(
                ImmutableSet.of( "chocolate ice cream",  "vanilla ice cream", "melted ice cream" ),
                0.0, 4));
        dispatcher.add(new DiscountOnLast(0.0, 3, "pizza"));
        dispatcher.add(new SpecialPrice(0.20, 5, "yogurt"));

        Map<String, Product> store = Maps.newHashMap();
        store.put("expired yogurt", new Product("yogurt", 0.45));
        store.put("cold pizza", new Product("pizza", 2.99));
        store.put("old juice", new Product("juice", 1.30));
        store.put("1935 wine", new Product("wine", 9.99));
        store.put("melted ice cream", new Product("melted ice cream", 1.2));
        store.put("vanilla ice cream", new Product("vanilla ice cream", 1.0));
        store.put("chocolate ice cream", new Product("chocolate ice cream", 0.95));

        do {
            switch (state) {
                case MAIN:
                    System.out.print("Commands:\n P - add product\n C - Checkout\n>>> ");
                    input = bufferRead.readLine();
                    if ("p".equalsIgnoreCase(input))
                        state = State.PRODUCTS;
                    if ("c".equalsIgnoreCase(input))
                        state = State.CHECKOUT;
                    break;
                case PRODUCTS:
                    store.forEach((s, product) -> System.out.println(s + " >>> " + product.getPrice()));
                    System.out.print("Name: ");
                    String prodName = bufferRead.readLine();
                    if (store.containsKey(prodName)) {
                        cart.add(store.get(prodName).clone());
                    } else {
                        System.out.println("Product Not available");
                    }
                    state = State.MAIN;
                    break;
            }
        } while (state != State.CHECKOUT);

        cart = new Cart(dispatcher.dispatch(cart));
        System.out.println("Here is your bill:\n" + cart.getReceipt() + "\nTOTAL = " + cart.checkout());
    }

}
