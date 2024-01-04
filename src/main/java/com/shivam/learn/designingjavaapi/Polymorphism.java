package com.shivam.learn.designingjavaapi;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sksingh created on 11/09/23
 */
public class Polymorphism {

    private static final String ELEMENTS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int MULTIPLY_FACTOR = 10_000;
    private static final int ORDER_ID_LEN = 8;

    public static void main(String[] args) {
        //        Arrays.asList(1, 2, 4)
        //                .stream()
        //                .filter(x -> ((x % 2) == 0))
        //                .collect(Collectors.toList());


        System.out.println(base62ToBase10("23C"));

        System.out.println(base62Encoding(uniqueId()));
    }


    public static String base62Encoding(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, ELEMENTS.charAt((int) (n % 62)));
            n /= 62;
        }

        final ThreadLocalRandom r = ThreadLocalRandom.current();
        int index;
        while (sb.length() != ORDER_ID_LEN) {
            index = r.nextInt(ELEMENTS.length());
            sb.insert(0, ELEMENTS.charAt(index));
        }

        return sb.toString();
    }

    public static int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;

    }

    public static int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }

    public static Long uniqueId() {
        long ts = Instant.now().toEpochMilli();
        int randomFactor = ThreadLocalRandom.current().nextInt(MULTIPLY_FACTOR);

        return (ts * MULTIPLY_FACTOR) + randomFactor;
    }
}
