package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * find the maximum and minimum values in a list of integers using streams.
 */
public class Ex7 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Integer max = list.stream()
                .max(Integer::compareTo)
                .orElse(null);
        System.out.println(max);

        Integer min = list.stream()
                .min(Integer::compareTo)
                .orElse(null);
        System.out.println(min);
    }
}
