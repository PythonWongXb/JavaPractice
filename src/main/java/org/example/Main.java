package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Consumer2<Integer> consumer2 = (x) -> { return x; };
        Demo demo = () -> { System.out.println("demo"); };
        Demo demo3 = new Demo() {
            @Override
            public void demo2() {
                System.out.println("demo2");
            }
        };
        demo.demo2();
        demo3.demo2();
        Integer result = consumer2.accept(3);
        System.out.println(result);

        List<String> strings = Arrays.asList("m", "g");
//        strings.add("h");
        List stringList = new ArrayList(strings);
        System.out.println(stringList);
        List<Integer> list2= new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(list2);
        List<Integer> list3 =
                Stream.concat(
                    Stream.of(1, 1, 2, 3, 3, 999999)
                        .filter(item -> item > 0)
                        .map(item -> item * 2)
                        .limit(5)
                        .skip(1)
                        .peek(item -> System.out.println("peek " + item)),
                    Stream.of(8)
                )
                        .distinct()
                        .sorted((a, b) -> a > b ? -1 : 1)
                        .collect(Collectors.toList());
        list3.add(123);
        System.out.println(list3);

    }
}

@FunctionalInterface
interface Consumer2<T> {
    Integer accept(T t);
}

interface Demo {
    void demo2();
    default void demo3() {
        System.out.println("demo3");
    };

}