package org.example.generics.bound;

import java.util.ArrayList;
import java.util.List;
class Fruit {

}
class Apple extends Fruit {

}

class SepcialApple extends Apple {}
class Orange extends Fruit {

}

// 泛型绝对是Java的一种缺陷。
// class 1：意识到泛型是存在问题的
public class CovariantArrays {
    public static void main(String[] args) {
        // 苹果框
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new SepcialApple();
        try {
            fruits[2] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        // 你无法将包含Apple的泛型传递给包含Fruit的泛型
        // List<Fruit> f = new ArrayList<Apple>();
        // 我们讨论的是集合类，而不是他们所持有的对象。这一筐什么东西才是集合所care的
        // 苹果框就是苹果框，水果框就是水果框。但水果框他就不是苹果框，苹果框也不是水果框。

        // 泛型并没有内建的协变性，数组是语言内部定义的，因此可以同时获得编译时和运行时的内建检查
    }
}
