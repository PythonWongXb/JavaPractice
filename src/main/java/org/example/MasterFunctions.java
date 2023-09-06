package org.example;

import java.util.function.Function;

class Input {
    @Override
    public String toString() {
        return "Input";
    }
}

class Output {
    @Override
    public String toString() {
        return "Output";
    }
}
public class MasterFunctions {
    static Function<Input, Output> f = transform(input -> {
        System.out.println(input);
        return new Output();
    });

    static Function<Input, Output> f2 = transformCompose(input -> {
        System.out.println(input);
        return new Output();
    });


    private static Function<Input, Output> transformCompose(Function<Input, Output> f) {
        return f.compose(input -> {
            System.out.println(input);
            return input;
        });
    }

    private static Function<Input, Output> transform(Function<Input, Output> f) {
        return f.andThen(output -> {
            System.out.println(output);
            return output;
        });
    }

    public static void main(String[] args) {
//        Output o = f.apply(new Input());
        Output o2 = f2.apply(new Input());
        System.out.println(o2);
    }
}
