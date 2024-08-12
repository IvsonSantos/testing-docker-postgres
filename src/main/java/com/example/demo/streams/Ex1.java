package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Write a Java program to calculate the average of a list of integers using streams.
 */
public class Ex1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,2,4,4);

        Double media = list.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(media);

        /*
          In the above exercise, we have a list of integers.
          Using streams, we convert each integer to a double using the mapToDouble method
          and calculate the average through the average() method,
          and finally retrieve the average value using the orElse method in case the stream is empty.
          The average value is then printed to the console.
         */

    }
}
