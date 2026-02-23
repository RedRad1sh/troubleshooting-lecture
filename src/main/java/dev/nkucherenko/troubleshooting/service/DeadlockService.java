package dev.nkucherenko.troubleshooting.service;

/**
 * @author nkucherenko
 */
public interface DeadlockService {
    void createDeadlock(String mon1, String mon2) throws InterruptedException;
}
