package org.example.generics.bound;

// 通配符的意义
public class Wildcards {
    static void rawArgs(Hold hold, Object arg) {
        hold.set(arg);
        Object d = hold.get();
    }
    static void unboundArg(Hold<? extends Object> hold, Object arg) {
        // 不确定的类型，还是一样的问题，一筐Apple里面，别传递一个Object
//        hold.set(arg);
        Object o = hold.get();
    }

    static <T> T exact1(Hold<T> hold) {
        return hold.get();
    }

    static <T> T exact2(Hold<T> hold, T arg) {
        hold.set(arg);
        return hold.get();
    }

    static <T> T wildSubType(Hold<? extends T> hold, T arg) {
        // 在一筐水果中，放一个水果是不合法的。为了防止向一筐Apple中放入Orange，所以不允许
//        hold.set(arg);
        return hold.get();
    }
    static <T> void wildSuperType(Hold<? super T> hold, T arg) {
        hold.set(arg);
        Object o = hold.get();
    }
}
