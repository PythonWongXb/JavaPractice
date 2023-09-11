package org.example.generics.bound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// 协变型与泛型
// 帮助Java编译器与运行时去检查错误
// 类型擦除 Before List<Apple> 与 List<Orange> 都是 List<Object>
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // 为啥不能add Apple？？？完全符合逻辑吧！！！
        // 但是flist并不能真正持有<? extends Fruit>的List。就是不能add
        List<? extends Fruit> flist = new ArrayList<>();
        // ls.add(new Apple());
        flist.add(null);
        // 当然从水果框里面拿出来的肯定是水果。
        Optional<Fruit> fruit = Optional.of(flist.get(0));
        // 通配符指向了某个确定的类型，因此真正的意义是：某种flist引用未指定具体的类型
        // 因此被赋值的List必须持有某种具体的类型，例如Fruit或者Apple

        // 编译器并不知道这件事：Apple可以加入<? extends Fruit>
        // 该类型必须持有某个Fruit或者他们的子类，但是如果你并不关心他具体是什么类型，
        // 你能用这样一个list做什么呢，如果你不知道List持有的类型是什么，你又如何安全地
        // 向List中添加对象呢，正如 CovariantArrays 一样。

        // 一句话，不支持。服了。
        // 只能初始化支持。
        List<? extends Fruit> flist2 = new ArrayList<>(Arrays.asList(new Apple(), new Orange()));
        Fruit f2 = flist2.get(0);
        Apple a2 = (Apple) flist2.get(0);

        List<? super Fruit> slist2 = new ArrayList<>(Arrays.asList(new Apple(), new Orange()));
        Object f22 = slist2.get(0);
        // 但是子类可以。啥？刚才不是说super是Fruit的父类吗，怎么子类也可以了？
        // 多态：向上转型：Fruit的子类一定是Fruit
        slist2.add(new Apple());
        slist2.add(new Orange());
        Object r = slist2.get(0);
        // 父类，不一定是Fruit，只有Object才安全
    }
}

