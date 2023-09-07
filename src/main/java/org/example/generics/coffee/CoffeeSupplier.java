package org.example.generics.coffee;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.Random;

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    private final List<Class<? extends Coffee>> types = new ArrayList<>(
            Arrays.asList(
                    Coffee1.class,
                    Coffee2.class,
                    Coffee3.class,
                    Coffee4.class,
                    Coffee5.class
            )
    );
    private static final Random rand = new Random(42);
    int size;
    CoffeeSupplier (int size) { this.size = size; }
    CoffeeSupplier () {}

    @Override
    public Coffee get() {
        try {
            return types.get(rand.nextInt(types.size())).getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeIterator();
    }

    class CoffeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stream.generate(CoffeeSupplier::new)
                .limit(5)
                .forEach(items -> System.out.println(items.get()));
        for (Coffee coffee : new CoffeeSupplier(5)) {
            System.out.println(coffee);
        }
    }
}
