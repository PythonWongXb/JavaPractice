package org.example.generics;

public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    final D d;
    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    public String rep() {
        return super.rep() + ", " + d;
    }
    public static void main(String[] args) {
        Object obj = new Object();
        Tuple4<Integer, String, String, Object> t = new Tuple4<>(1, "hello", "3", obj);
        System.out.println(t);
    }
}
