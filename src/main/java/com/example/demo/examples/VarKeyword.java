package com.example.demo.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarKeyword {

    public static void main(String[] args) {

        // java 8 way
        Map<String, List<MyDtoType>> myMap = new HashMap<>();

        // java 10 way
        var myMap2 = new HashMap<String, List<MyDtoType>>();
    }
}
