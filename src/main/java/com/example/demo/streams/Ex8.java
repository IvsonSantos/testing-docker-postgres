package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * find the second smallest and largest elements in a list of integers using streams.
 */
public class Ex8 {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        // Find the second smallest element
        Integer secondSmallest = nums.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondSmallest);

        // Find the second largest element
        Integer secondLargest = nums.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondLargest);
    }
}
