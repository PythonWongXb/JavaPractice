package org.example.store;

import java.util.ArrayList;

public class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelf, int nProduct) {
        for (int i = 0; i < nShelf ; i++) {
            add(new Shelf(nProduct));
        }
    }
}
