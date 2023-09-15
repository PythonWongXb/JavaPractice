package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomList<T> extends ArrayList<T> {
    private final Random rand = new Random(47);
    public T select() {
        return get(rand.nextInt(size()));
    }
    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream(
                    ("The quick brown fox jumped over " +
                            "the lazy brown dog"
                    )
                            .split(" ")
                )
                .forEach(rs::add);
        IntStream.range(0, 11).forEach(i ->
                System.out.print(rs.select() + " "));
    }
}
/* Output:
brown over fox quick quick dog brown The brown lazy
brown
*/
