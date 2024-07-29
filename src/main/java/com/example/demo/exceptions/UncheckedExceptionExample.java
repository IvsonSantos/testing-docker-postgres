package com.example.demo.exceptions;

/**
 * Some common unchecked exceptions in Java are NullPointerException, ArrayIndexOutOfBoundsException and IllegalArgumentException.
 */
public class UncheckedExceptionExample {

    /**
     * If a program throws an unchecked exception, it reflects some error inside the program logic.
     */
    private static void divideByZero() {
        int numerator = 1;
        int denominator = 0;
        int result = numerator / denominator;
    }

}
