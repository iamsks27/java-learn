package com.shivam.learn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    private boolean task() {
        System.out.println("Executing the task");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution complete");
        return true;
    }


    private void createTask(int num) {
        if (num % 2 == 0) {
            System.out.println(Thread.currentThread() + "Even");
        } else {
            System.out.println(Thread.currentThread() + "Odd");
            throw new RuntimeException("Failed for odd number");
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFutureTest cft = new CompletableFutureTest();

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> cft.createTask(2), executorService),
                CompletableFuture.runAsync(() -> cft.createTask(4), executorService),
                CompletableFuture.runAsync(() -> cft.createTask(5), executorService)
        ).join();

        executorService.shutdown();
        System.out.println("Completed the tasks");
    }
}
