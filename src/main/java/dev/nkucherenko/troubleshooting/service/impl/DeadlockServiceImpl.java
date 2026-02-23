package dev.nkucherenko.troubleshooting.service.impl;

import dev.nkucherenko.troubleshooting.service.DeadlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author nkucherenko
 */
@Service
@Slf4j
public class DeadlockServiceImpl implements DeadlockService {
    @Override
    public void createDeadlock(String mon1, String mon2) throws InterruptedException {
        synchronized (mon1) {
            log.debug("Первый монитор занят");
            Thread.sleep(5000);
            synchronized (mon2) {
                log.debug("Второй монитор занят");
                Thread.sleep(5000);
            }
        }
    }
}
