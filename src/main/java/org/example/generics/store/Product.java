package org.example.generics.store;

import java.util.Random;
import java.util.function.Supplier;

public class Product {
    private final int id;
    private final String desc;
    private final double price;
    Product(int idNumber, String descString, double priceDouble) {
        id = idNumber;
        desc = descString;
        price = priceDouble;
    }
    static Supplier<Product> generator = () -> {
        Random rand = new Random();
        return new Product(
                rand.nextInt(1000),
                "test",
                Math.round(rand.nextDouble() * 1000.0) + 0.99
        );
    };

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
    }

}
