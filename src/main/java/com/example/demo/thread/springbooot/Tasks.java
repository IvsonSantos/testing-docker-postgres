package com.example.demo.thread.springbooot;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class Tasks {

    /**
     * Thread Pool provides a straightforward way to configure a thread pool with core pool size, max pool size,
     * queue capacity, etc., using Spring’s configuration properties.
     * @return
     */
    //@Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("Executor-");
        executor.initialize();
        return executor;
    }

}
