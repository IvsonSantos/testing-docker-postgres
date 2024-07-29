package com.example.demo.thread.sync;

public class SharedResource {

    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
