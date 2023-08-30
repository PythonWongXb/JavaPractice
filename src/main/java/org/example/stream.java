package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        test4();
    }
    public static void test4() {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People(1, "小王", 1));
        peopleList.add(new People(3, "小李", 2));
        peopleList.add(new People(2, "小张", 2));
        peopleList.add(new People(4, "小皇", 1));

        //根据年龄分组
        Map<Integer, List<People>> jgidMap1 = peopleList.stream().collect(Collectors.groupingBy(new Function<People, Integer>() {
            @Override
            public Integer apply(People people) {
                return people.getId();
            }
        }));
        //或者使用lambda表达式
        Map<Integer, List<People>> jgidMap2 = peopleList.stream().collect(Collectors.groupingBy(People::getId));
        System.out.println("根据年龄分组");
        jgidMap1.forEach((key, value) -> {
            value.forEach(System.out::println);
            System.out.println(key + "---->" + value);
        });


        //或者使用lambda表达式2
        Map<Integer, List<People>> jgidMap7 = peopleList.stream().collect(Collectors.groupingBy(item -> item.getId()));
        System.out.println("根据年龄分组 jgidMap3");
        jgidMap7.forEach((key, value) -> {
            System.out.println(key + "jgidMap7 ---->" + value);
        });

        //jgid奇数一组偶数一组
        Map<String, List<People>> jgidMap3 = peopleList.stream().collect(Collectors.groupingBy(s -> {
            if (s.getId() % 2 == 0) {
                return "jgid为偶数";
            } else {
                return "jgid为奇数";
            }
        }));
        System.out.println("jgid奇数一组偶数一组");
        jgidMap3.forEach((key, value) -> {
            System.out.println(key + "---->" + value);
        });

        //根据jgid分组且规定为最大一组(规约：reducing)
        Map<Integer, Optional<People>> jgidMap4 = peopleList.stream().collect(Collectors.groupingBy(People::getId,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(People::getId)))

        ));
        System.out.println("jgid分组后最大值");
        jgidMap4.forEach((key, value) -> {
            System.out.println(key + "---->" + value);
        });
    }
}

class People extends Object {
    int id;
    String name;
    int age;
    People(int id, String name, int age) {
		this.id = id;
        this.age = age;
        this.name =  name;
    }

    public Integer getId() {
        return (Integer) age;
    }

    @Override
    public String toString() {
        Integer ids = (Integer) id;
        Integer ages = (Integer) age;
        return String.format("id: %d, name: %s, age: %d", ids, name, ages);
    }
}
