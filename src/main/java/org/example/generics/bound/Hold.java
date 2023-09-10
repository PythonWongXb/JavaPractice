package org.example.generics.bound;

public class Hold<T> {
    T value;
    Hold (T value) {
        this.value = value;
    }
    T get() {
        return value;
    }

    public static void main(String[] args) {
        Hold<Integer> hold1 = new Hold<Integer>(5);
    }
}
