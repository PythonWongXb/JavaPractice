package org.example.generics.bound;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards1 {
    static List<?> list2;
    static List<? extends Object> list3;
    static void assign2(List<?> list) {
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list2 = list;
        list3 = list;
    }
    public static void main(String[] args) {
        List<?> a1 = new ArrayList<>();
        assign2(a1);
        assign3(a1);

        assign2(new ArrayList());
        assign3(new ArrayList());
    }
}

// 结论：<? extends Object>与<?> TMD完全一样。
