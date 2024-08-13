package com.example.demo.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

    /**
     * What you really need to do is to return an integer when you have a proper integer in this string and nothing
     * if it is a corrupted string. This is a job for a flatmapper.
     * If you can parse an integer, you can return a stream with the result. In the other case, you can return an empty stream.
     */
    public static void main(String[] args) {

        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };

        List<String> strings = List.of("1", " ", "2", "3 ", "", "3");

        List<Integer> ints =
                strings.stream()
                        .flatMap(flatParser)
                        .toList();
        System.out.println("ints = " + ints);

        // same resulta but no stream created
        List<Integer> nums = strings.stream()
                .<Integer>mapMulti((string, consumer) -> {
                    try {
                        consumer.accept(Integer.parseInt(string));
                    } catch (NumberFormatException e) {
                    }
                })
                .toList();
        System.out.println(nums);

    }
}
