package org.example;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.*;

class A {}
class B {}
class C {}

public class LambdaFunctionMagic {
    static A a = new A();
    static B bInstance = new B();
    C cInstance = new C();
    private Object f00;

    A f1() {
        return LambdaFunctionMagic.a;
    }
    int f2 (A a1, A a2) {
        return 1;
    };
    void f3 (A a) {  }
    void f4 (A a, B b) {  }
    C f5 (A a) { return cInstance; }
    C f6 (A a, B b) { return cInstance; };
    boolean f7 (A a) { return true; }
    boolean f8 (A a, B b) { return true; }
    A f9 (A a) { return a; }
    A f10(A a, A a2) { return a;}

    public void consumer (String msg) {
        System.out.println(msg);
    }
    private String callable () {
        return "12";
    };
    private void runAble() {}
    interface TransformInterface {
        A transform();
    }
    @FunctionalInterface
    interface ConsumerInterface<T, U, R>{
        R apply(T t, U u);
    }

    String demo2(String s, String s2) {
        return s + s2;
    }
    public static void main(String[] args) {
        LambdaFunctionMagic lambdaFunctionMagic = new LambdaFunctionMagic();
        Supplier<A> f133 = lambdaFunctionMagic::f1;
        Comparator<A> f12 = lambdaFunctionMagic::f2;
        Consumer<A> f3 = lambdaFunctionMagic::f3;
        BiConsumer<A, B> f4 = lambdaFunctionMagic::f4;
        Function<A, C> f5 = lambdaFunctionMagic::f5;
        BiFunction<A, B, C> f6 = lambdaFunctionMagic::f6;
        Predicate<A> f7 = lambdaFunctionMagic::f7;
        BiPredicate<A, B> f8 = lambdaFunctionMagic::f8;
        UnaryOperator<A> f9 = lambdaFunctionMagic::f9;
        BinaryOperator<A> f10 = lambdaFunctionMagic::f10;
        Object f001 = lambdaFunctionMagic.f00;
        Consumer<String> callable = lambdaFunctionMagic::consumer;
        Callable<String> callable1 = lambdaFunctionMagic::callable;
        Runnable runAble1 = System.out::println;
        Runnable runAble2 = lambdaFunctionMagic::runAble;
//        TransformInterface f122 = LambdaFunctionMagic::f1;

        ConsumerInterface<String, String, String> c = lambdaFunctionMagic::demo2;
        c = (s1, s3) -> s1 + " " + s3;
    }


}

