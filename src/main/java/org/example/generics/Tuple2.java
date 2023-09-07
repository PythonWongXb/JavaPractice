package org.example.generics;

public class Tuple2<A, B> {
    public final A a1;
    public final B b1;

    public Tuple2(A a1, B b1) {
        this.a1 = a1;
        this.b1 = b1;
    }

    public String rep() {
        return a1 + ", " + b1;
    }
    @Override
    public  String toString() {
        return "("  + rep() + ")";
    }

    public static void main(String[] args) {
        Tuple2<Integer, String> t = new Tuple2<>(1, "hello");
        System.out.println(t);
    }
}
