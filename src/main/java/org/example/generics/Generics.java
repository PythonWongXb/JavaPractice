package org.example.generics;
// 泛型
public class Generics<T> {
    private T a;

    public void setA(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public static void main(String[] args) {
        Generics<Integer> g = new Generics<>();
        g.setA(1);
        System.out.println(g.getA());
    }
}

