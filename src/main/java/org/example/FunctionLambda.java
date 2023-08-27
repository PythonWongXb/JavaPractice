package org.example;
/*
* - 接口只处理对象，而非基本类型，那就会用一个直接的名字：Function、Consumer、Predicate。类型通过泛型传
* - 如果接口【接收】一个基本类型的参数，则会用名字的第一部分来标示，例如。LongConsumer，DoubleConsumer、IntPredicate
* - 如果接口【返回】的是基本类型，则会用To来标示，例如。ToLongFunction<T>和IntToLongFunction
* - 如果接口【返回类型】与【参数类型】相同，则会命名为Operator。UnaryOperator用与表示一个参数，BinaryOperator则
* - 如果接口接受一个参数并返回boolean，则会被命名为Predicate
* - 如果接口接受两个不同类型的参数，则名字中会有一个Bi，BiPredicate。
! 12
? 123
todo 12
* */
import java.util.function.*;
class Foo {};
class Bar {
    Foo f;
    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;
    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long i;
    LBaz(long i) {
        this.i = i;
    }
}


class DBaz {
    double i;
    DBaz(double i) {
        this.i = i;
    }
}

public class FunctionLambda {
    static Function<Foo, Bar>  f1 = f -> new Bar(f);
    static Function<Foo, Bar>  f2 = Bar::new;
    static IntFunction<IBaz> f22 = IBaz::new;
    static DoubleFunction<DBaz> f4 = DBaz::new;
    static ToIntFunction<IBaz> f5 = ib -> ib.i;
    static ToLongFunction<LBaz> f6 = lb -> lb.i;
    static ToDoubleFunction<DBaz> f7 = db -> db.i;
    static IntToLongFunction f8 = i -> i;
    static IntToDoubleFunction f9 = i -> i;
    // 窄化处理
    static LongToIntFunction f10 = i -> (int) i;
    static LongToDoubleFunction f11 = i -> i;
    static DoubleToIntFunction f12 = di -> (int) di;
    static DoubleToLongFunction f13 = di -> (long) di;
    public static void main(String[] args) {
        Long l = f8.applyAsLong(12);
        Double d = f9.applyAsDouble(12);
        int i = f10.applyAsInt(12L);
    }
}