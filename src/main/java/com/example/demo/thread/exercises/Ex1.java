package com.example.demo.thread.exercises;

/**
 * create a basic Java thread that prints "Hello, World!" when executed.
 */
public class Ex1 extends Thread {

    @Override
    public void run() {
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        Ex1 e = new Ex1();
        e.start();
    }
}
