package com.example.demo.streams;

import java.util.List;

public class StreamPeek {

    /**
     * The Stream API has a method for that: the peek() method. This method is meant to be used to debug your data processing pipeline.
     * You should not use this method in your production code.
     */
    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three", "four");
        List<String> result =
                strings.stream()
                        .peek(s -> System.out.println("Starting with = " + s))
                        .filter(s -> s.startsWith("t"))
                        .peek(s -> System.out.println("Filtered = " + s))
                        .map(String::toUpperCase)
                        .peek(s -> System.out.println("Mapped = " + s))
                        .toList();
        System.out.println("result = " + result);
    }
}
