package org.example.generics.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shelf extends ArrayList<Product> {
    Shelf(int nProduct) {
        List<Product> products = Stream
                .generate(Product.generator)
                .limit(nProduct)
                .collect(Collectors.toList());
        addAll(products);
    }
}
