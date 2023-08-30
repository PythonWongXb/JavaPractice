package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ForInCollections {
    public static void main(String[] args) {
        Collection<String> cs = new ArrayList<>();
        String[] s = "12 0".split(" ");
        Collections.addAll(cs, "12 23".split(" "));
        System.out.println(cs);
    }
}
