package com.example.demo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * sort a list of strings in alphabetical order, ascending and descending using streams.
 */
public class Ex6 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("brasil", "canada", "argentina");

        List<String> asc = names.stream()
                .sorted()
                .toList();
        System.out.println(asc);

        List<String> desc =  names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(desc);
    }
}
