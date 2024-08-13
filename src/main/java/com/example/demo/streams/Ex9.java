package com.example.demo.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ex9 {

    public static void main(String[] args) {
        List<String> strings = List.of("one", "two", "three", "four");

        var map = strings.stream()
                .collect(Collectors.groupingBy(
                    String::length, //It groups the strings by their length
                    Collectors.counting() // It counts the number of strings for each length
                ));

        map.forEach((key, value) -> System.out.println(key + " :: " + value));
    }
}
