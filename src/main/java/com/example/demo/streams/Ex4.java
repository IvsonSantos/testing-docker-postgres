package com.example.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,4,5);
        System.out.println(list);


        List<Integer> sem =  list.stream().distinct().collect(Collectors.toList());
        System.out.println(sem);
    }
}
