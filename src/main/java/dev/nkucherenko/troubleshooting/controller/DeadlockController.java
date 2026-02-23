package dev.nkucherenko.troubleshooting.controller;

import dev.nkucherenko.troubleshooting.service.DeadlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author nkucherenko
 */
@RequestMapping("/deadlock")
@RestController
@RequiredArgsConstructor
public class DeadlockController {
    private final DeadlockService deadlockService;

    @GetMapping
    public void createDeadlock(@RequestParam String mon1, @RequestParam String mon2) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            try {
                deadlockService.createDeadlock(mon1, mon2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(() -> {
            try {
                deadlockService.createDeadlock(mon2, mon1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
