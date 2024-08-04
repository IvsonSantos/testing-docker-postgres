package com.example.demo.thread.springbooot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;


@Component
@Slf4j
public class TaskService {

    private final BlockingQueue<Runnable> taskQueue;
    private final ExecutorService executor;
    private final Thread listenerThread;
    private volatile boolean running;

    public TaskService() {
        this.taskQueue = new LinkedBlockingDeque<>();
        this.executor = Executors.newFixedThreadPool(5);
        this.running = true;

        this.listenerThread = new Thread(this::listenForTasks);
    }

    @PostConstruct
    public void start() {
        log.info("Starting the executors");
        listenerThread.start();
    }

    private void listenForTasks() {
        log.info("Listening for tasks");
        while (running) {
            try {
                Runnable task = taskQueue.take();
                executor.submit(task);
            } catch (InterruptedException e) {
                if (!running) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void submitTask(Runnable task) {
        if (running) {
            taskQueue.add(task);
        }
    }

    @PreDestroy
    public void shutdown() {
        log.info("Shutting down the executors");
        running = false;
        listenerThread.interrupt();
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
