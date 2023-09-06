package org.example;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<Integer> sum = Stream.of("1 2 3".split(" "))
                .map(Integer::parseInt);
        Optional<Integer> reduce = sum.reduce(Integer::sum);
        System.out.println(reduce.isPresent());
    }
}


class FileToWord {

    static String trim (String str2) {
        return str2.trim();
    };
    static Function<String, String> trans(UnaryOperator<String> func) {
        return func.andThen(FileToWord::trim);
    };
    public static Stream<String> stream(String filePath) throws Exception {
        Stream<String> lines = Stream.of(filePath).map(String::trim);
        return lines
                .map(String::toUpperCase)
                .map(String::trim);
    }

    public static void main(String[] args) throws Exception {
        String filePath = "  src/main/java/com/example/StreamPractice.java";
        Stream<String> stringStream = FileToWord.stream(filePath);
        System.out.println(stringStream.collect(Collectors.joining()));
        Function<String, String> f = trans(i -> i + "123");
        System.out.println(f.apply(filePath));
    }
}