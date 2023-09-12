package org.example.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
class Animal {}
class Flower {};
class Cat extends Animal {
    @Override
    public String toString() {
        return "Cat";
    }
}
class Dog extends Animal {
    @Override
    public String toString() {
        return "Dog";
    }
}
public class CheckedList {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    static void oldStyleMethod(List probablyDog, Animal animal) {
        probablyDog.add(animal);
    }

    public static void main(String[] args) {
        List<Dog> d1 = new ArrayList<>();
        oldStyleMethod(d1, new Cat()); // 问题非常大
        oldStyleMethod(d1, new Dog());
//        oldStyleMethod(d1, new Flower());
        System.out.println(d1);

        // 新方式
        List<Dog> d2 = Collections.checkedList(
                new ArrayList<>(),
                Dog.class
        );
        d2.add(new Dog());
//        d2.add(new Cat());
//        d2.add(new Flower());

    }

}
