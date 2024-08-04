package com.example.demo.thread.springbooot;

import java.util.concurrent.*;

public class ExecutorsTest {

    public void testExecutor() {

         // This executor has only one thread operating off an unbounded queue.
         // It is useful when you want to ensure that tasks are executed sequentially.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // This executor creates new threads as needed but will reuse previously constructed threads when available.
        // It is suitable for applications that launch many short-lived tasks.
        ExecutorService executor2 = Executors.newCachedThreadPool();

        // This executor is designed to schedule tasks to run after a given delay or execute periodically.
        // It is helpful for tasks that need to run at regular intervals.
        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(3);

        // This executor uses a work-stealing algorithm and can improve throughput in multi-processor systems.
        // It dynamically adjusts the number of threads based on the system’s workload.
        ExecutorService executor4 = Executors.newWorkStealingPool();

    }

}
