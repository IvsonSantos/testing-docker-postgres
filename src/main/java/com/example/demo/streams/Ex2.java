package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * Write a Java program to convert a list of strings to uppercase or lowercase using streams.
 */
public class Ex2 {

    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Primeiro", "Dois", "Tres");

        List<String> upper = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper);

        List<String> lower = nomes.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(lower);

        /*
        First convert the strings to uppercase by calling the toUpperCase method on each string,
        and then collect the results into a new list using the collect method.
        Similarly, convert the strings to lowercase by calling the toLowerCase method on each string.
         Finally, the uppercase and lowercase lists are printed to the console.
         */

    }

}
