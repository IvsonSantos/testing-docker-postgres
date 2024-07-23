package com.example.demo.examples;

public class PatterMatching {

    public static void main(String[] args) {
        MyClass o = new MyClass();

        // old way
        if (o instanceof MyClass) {
            MyClass s = (MyClass) o;
            System.out.println(s);
        }

        // new way
        if (o instanceof MySubClass s) {
            System.out.println(s);
        }

        System.out.println(formatter("exemplo"));
    }

    static String formatter(Object o) {
        String formatted = "unknown";

        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof String s) {
            formatted = String.format("string %s", s);
        }

        return formatted;
    }
}
