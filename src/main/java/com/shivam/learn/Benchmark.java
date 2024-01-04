package com.shivam.learn;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * @author sksingh created on 24/10/23
 */
public class Benchmark {

    private int compute() {
        IntSupplier s1 =
                () -> IntStream.range(0, 10_000)
                        .map(v -> 1)
                        .sum();

        IntSupplier s2 =
                () -> IntStream.range(0, 10_000)
                        .map(v -> 1)
                        .sum();

        IntSupplier s3 =
                () -> IntStream.range(0, 10_000)
                        .map(v -> 1)
                        .sum();

        return s1.getAsInt() + s2.getAsInt() + s3.getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Benchmark().compute());
    }

}
