package com.example.demo.thread.springbooot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  In this example, when a request is made to /tasks/submit, it submits 10 functions to the server.
 *  Each request will log started and completed within 5 seconds delay.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskServer;
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    public TaskController(TaskService taskServer) {
        this.taskServer = taskServer;
    }

    @PostMapping("/submit")
    public String submitTask() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            taskServer.submitTask(() -> {
                try {
                    log.info("Task {} started", finalI);
                    Thread.sleep(5000);
                    log.info("Task {} completed", finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return "Task submitted";
    }
}
