package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] firstArray = (T[]) first.toArray();
        T[] secondArray = (T[]) second.toArray();
        int minLength = Math.min(firstArray.length, secondArray.length);

        return IntStream.range(0, minLength)
                .mapToObj(i -> Stream.of(firstArray[i], secondArray[i]))
                .flatMap(s -> s);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10, 11);

        Stream<Integer> zippedStream = zip(stream1, stream2);

        zippedStream.forEach(System.out::println);
    }
}
