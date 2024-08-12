package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * calculate the sum of all even, odd numbers in a list using streams
 */
public class Ex3 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int evenSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(evenSum);

        int oddSum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(oddSum);

    }
}
