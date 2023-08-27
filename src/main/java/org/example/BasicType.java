package org.example;
// - 自动装箱/拆箱 https://www.zhihu.com/question/28502011/answer/2999070341
// - 类型转换
// - 类型窄化
// - 类型大小：boolean, char, byte, short, [int, float], [long double]
import java.util.function.Consumer;

public class BasicType {
    public static void main(String[] args) {
        double above = 0.7;
        double below = 0.4;

        float fabove = 0.7f;
        float fbelow = 0.4f;

        Consumer<Float> consumer = (Float f) -> {
            System.out.println("(int) " + Math.round(f));
        };
        Consumer<Double> consumerDouble = (Double d) -> {
            System.out.println("(double) " + Math.round(d));
        };
        consumerDouble.accept(above);
        consumerDouble.accept(below);
        consumer.accept(fabove);
        consumer.accept(fbelow);
    }
}
