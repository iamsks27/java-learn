package com.shivam.learn.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sksingh created on 12/02/24
 */
public class Test {

    private static void task() {
        try {
            System.out.println("Execution started");
            Thread.sleep(10_000);
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Execution completed");
    }

    public static void main(String[] args) {
        try (ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newFixedThreadPool(10)) {
            CompletableFuture.runAsync(Test::task, executors);

            System.out.println("Available threads: " + (executors.getCorePoolSize() - executors.getActiveCount()));
        }
    }
}
