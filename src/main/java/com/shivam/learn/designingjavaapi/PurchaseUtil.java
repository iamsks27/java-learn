package com.shivam.learn.designingjavaapi;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sksingh created on 22/12/23
 */
public class PurchaseUtil {

    private static final String ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int MULTIPLY_FACTOR = 10_000;
    private static final int DEFAULT_ORDER_ID_LEN = 8;

    private static final Set<String> orderIds = new HashSet<>();
    private static final Set<Long> uniqueIds = new HashSet<>();
    private static final AtomicLong SEQ_COUNTER = new AtomicLong();

    public static void main(String[] args) {

        String orderId;
        for (int i = 0; i < 20000000; i++) {
            // orderId = getPurchaseId();

             orderId = getPurchaseIdOld();
            if (orderIds.contains(orderId)) {
                System.out.println("Matching orderId: " + orderId);
            }

            orderIds.add(orderId);
        }
        System.out.println("Processed");
    }

    public static String getPurchaseIdOld() {
        final String charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final ThreadLocalRandom r = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < DEFAULT_ORDER_ID_LEN; i++) {
            int index = r.nextInt(charset.length());
            sb.append(charset.charAt(index));
        }

        return sb.toString();
    }

    public static String getPurchaseId() {
        return getPurchaseId(DEFAULT_ORDER_ID_LEN);
    }

    public static String getPurchaseId(int length) {
        StringBuilder sb = new StringBuilder();

        long n = uniqueId();
        while (n > 0 && sb.length() < length) {
            sb.append(ELEMENTS.charAt((int) (n % 62)));
            n /= 62;
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (sb.length() < length) {
            sb.append(ELEMENTS.charAt(random.nextInt(ELEMENTS.length())));
        }

        return sb.toString();
    }

    private static long uniqueId() {
        long ts = Instant.now().toEpochMilli();
        long sequence = SEQ_COUNTER.getAndIncrement();
        int randomFactor = ThreadLocalRandom.current().nextInt(1, MULTIPLY_FACTOR);

        return (ts * randomFactor) + sequence;
    }

}
