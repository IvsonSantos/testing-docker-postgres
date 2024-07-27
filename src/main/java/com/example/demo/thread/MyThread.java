package com.example.demo.thread;

/**
 * Extende a classe Thread
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread running");
    }
}
