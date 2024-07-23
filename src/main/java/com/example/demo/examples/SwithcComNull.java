package com.example.demo.examples;

public class SwithcComNull {

    public static void main(String[] args) {
        test(null);
        test("test");
    }

    static void test(String s) {
        if (s == null) {
            System.out.println("error");
            return;
        }
        switch (s) {
            case "test" -> System.out.println("perfect");
            default -> System.out.println("ok");
        }
    }

    // better on java 21
    static void test2(String s) {
        /*
        switch (s) {
            case null -> System.out.println("nulo");
            case "test" -> System.out.println("perfect");
            default -> System.out.println("ok");
        }

         */
    }
}
