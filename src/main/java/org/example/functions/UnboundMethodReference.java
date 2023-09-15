package org.example.functions;

import java.util.function.Function;

interface MakeString {
    String f();
}

class X {
    String f() {
        return "instance -> f";
    }
}
interface TransformX {
    String transform(X x);
}
public class UnboundMethodReference {
    public static void main(String[] args) {
        X x = new X();
        Function<X, String> f = X::f;
        TransformX f2 = X::f;
        System.out.println(f.apply(x));
        System.out.println(f2.transform(x));
        System.out.println(x.f());
    }
}
