package com.example.demo.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ConcatStram {

    /**
     * The reason why it is better to use the flatMap() way is that concat() creates intermediates streams during the concatenation.
     * When you use Stream.concat(), a new stream is created to concatenate your two streams.
     *
     * With the flatmap pattern, you just create a single stream to hold all your streams and do the flatmap. The overhead is much lower.
     */
    public static void main(String[] args) {
        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);

        // 1st pattern: concat
        List<Integer> concat = Stream
                .concat(list0.stream(), list1.stream())
                .toList();
        System.out.println(concat);

        // 2nd pattern: flatMap
        List<Integer> flatMap = Stream
                .of(list0.stream(), list1.stream(), list2.stream())
                .flatMap(Function.identity())
                .toList();
        System.out.println(flatMap);
    }
}
