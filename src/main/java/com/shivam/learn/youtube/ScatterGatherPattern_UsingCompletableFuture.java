package com.shivam.learn.youtube;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScatterGatherPattern_UsingCompletableFuture {

    private static final String URL1 = "https://xyz_1.com";
    private static final String URL2 = "https://xyz_2.com";
    private static final String URL3 = "https://xyz_3.com";

    private Set<Integer> getPrices(int prdId) throws InterruptedException, ExecutionException, TimeoutException {
        final Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        final CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(URL1, prdId, prices));
        final CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(URL2, prdId, prices));
        final CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(URL3, prdId, prices));

        final CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.get(3, TimeUnit.SECONDS);
        return prices;
    }

    private static class Task implements Runnable {

        private final String url;
        private final int productId;
        private final Set<Integer> prices;

        public Task(String url, int productId, Set<Integer> prices) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call or do some task
            prices.add(price);
        }
    }


}
