package org.example.store;

import java.util.ArrayList;

// Store -> nAisle -> nShelf -> nProduct
public class Store extends ArrayList<Aisle> {
    int sum = 0;
    Store(int nAisle, int nShelf, int nProduct) {
        for (int i = 0; i < nAisle ; i++) {
            add(new Aisle(nShelf, nProduct));
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        this.forEach(aisle -> {
            aisle.forEach(shelf -> {
                shelf.forEach(product -> {
                    result.append(product.toString());
                    result.append("\n");
                    sum++;
                });
            });
        });
        return result.toString();
    }
    public static void main(String[] args) {
        Store store = new Store(5, 4, 3);
        System.out.println(store);
        System.out.println(store.size());
        System.out.println(store.get(0).size());
        System.out.println(store.get(0).get(0).size());
        System.out.println(store.sum);
    }
}
