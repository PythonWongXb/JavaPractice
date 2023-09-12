package org.example.generics;

import org.example.generics.bound.Hold;

public class CaptureConversion {
    static <T, U extends T> void f1(Hold<T> hold, Hold<U> arg) {
        hold.set(arg.get());
        T t =  hold.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static <T> void f2(Hold<?> hold) {
        // 捕获为已知参数类型
//        f1(hold, hold);
    }

    public static void main(String[] args) {
        final Hold<String> hRaw = new Hold<>("12");
        // 有警告
        f1(hRaw, hRaw);
//        f2(hRaw);
    }
}
