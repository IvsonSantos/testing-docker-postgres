package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
count the number of strings in a list that start with a specific letter using streams.
 */
public class Ex5 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("primeiro", "segundo", "proximo");
        String startingLetter = "p";

        long count = names.stream()
                .filter(n -> n.startsWith(startingLetter))
                .count();
        System.out.println(count);

    }
}
