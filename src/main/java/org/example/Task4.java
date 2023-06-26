package org.example;

import java.util.stream.Stream;

public class Task4 {
    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        Stream<Long> randomStream = linearCongruentialGenerator(1L, a, c, m);

        randomStream.limit(10) //limit for tests
                .forEach(System.out::println);
    }
}
