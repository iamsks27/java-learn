package com.shivam.learn.youtube;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScatterGatherPattern_UsingCountDown {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(4);
    private static final String URL1 = "https://xyz_1.com";
    private static final String URL2 = "https://xyz_2.com";
    private static final String URL3 = "https://xyz_3.com";

    private Set<Integer> getPrices(int prdId) throws InterruptedException {
        final Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        final CountDownLatch latch = new CountDownLatch(3);
        THREAD_POOL.submit(new Task(URL1, prdId, prices, latch));
        THREAD_POOL.submit(new Task(URL2, prdId, prices, latch));
        THREAD_POOL.submit(new Task(URL3, prdId, prices, latch));

        // wait for countdown to zero or timeout, whichever occurs first
        latch.await(3, TimeUnit.SECONDS);

        return prices;
    }

    private static class Task implements Runnable {

        private final String url;
        private final int productId;
        private final Set<Integer> prices;
        private final CountDownLatch latch;

        public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
            this.url = url;
            this.productId = productId;
            this.prices = prices;
            this.latch = latch;
        }

        @Override
        public void run() {
            int price = 0;
            // make http call or do some task
            prices.add(price);
            latch.countDown();
        }
    }

}
