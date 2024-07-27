package com.example.demo.thread;

public class Principal {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnabl());

        thread1.start();
        thread2.start();
    }

}
