package com.example.demo.thread.sync;

public class Example {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedResource.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
           for (int i = 0; i < 1000; i++) {
               sharedResource.increment();
           }
        });

        thread1.start();
        thread2.start();

        System.out.println("Counter before join: " + sharedResource.getCounter());

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("Counter after join: " + sharedResource.getCounter());

    }
}
