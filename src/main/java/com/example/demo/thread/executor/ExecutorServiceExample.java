package com.example.demo.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        // create a fixed size thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // The loop submits ten tasks to the executor, which efficiently manages their execution on the available threads.
        // Once all tasks are complete, the executor is gracefully shut down.
        // submit taks to the executor
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task " + taskNumber +
                    " executed by thread " + Thread.currentThread().getName());
            });
        }

        // shutdown the executor when tasks are done
        executor.shutdown();
    }

}
