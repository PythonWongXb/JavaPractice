package org.example.generics.coffee;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + "]";
    }

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        System.out.println(coffee);
    }
}
