package com.example.demo.thread.springbooot;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Spring Boot provides the @Async annotation to mark methods for asynchronous execution,
 * allowing you to run them in a separate thread.
 */
@Service
public class AsyncMethod {

    @Async
    public void asyncMethod() {
        // Perform asynchronous task
    }

    /**
     * Spring Boot offers the @Scheduled annotation to schedule tasks at fixed rates, with fixed delays, or according to a cron expression.
     */
    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        // Task to run every 5 seconds
    }

    /**
     * Spring Boot provides abstractions for task executors,
     * making it easy to configure and use different types of executors for various needs.
     *
     * This task executor doesn’t use a thread pool but creates a new thread for each task. It can be helpful for lightweight,
     * short-lived tasks but is inefficient for high-load scenarios.
     */
    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }



}
