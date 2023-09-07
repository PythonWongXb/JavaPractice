package org.example.generics;

public class Tuple3<A, B, C> extends Tuple2<A, B> {
    final C c;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    public String rep() {
        return super.rep() + ", " + c;
    }
    public static void main(String[] args) {
        Tuple3<Integer, String, String> t = new Tuple3<>(1, "hello", "3");
        System.out.println(t);
    }
}
