package com.shivam.learn.youtube;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class GenericsRunner {

    public static <T> void copy(List<T> from, List<T> to) {
        to.addAll(from);
    }

    // recursive type bound
    public static <T extends Comparable<T>> void copyAllBut(List<T> from, List<T> to, T exclude) {
        for (final T t : from) {
            if (t.compareTo(exclude) != 0) {
                to.add(t);
            }
        }
    }

    static <T> T doubleValue(T value) {
        return value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

    }

    //upper bound
    //lower bound

    // type checking at compile time

    // casting pain

    // super -> same, base class or base interface.

    // extends -> same, derived class

    // Type parameters:
        // A placeholder for a type argument

    interface Comparable<E> {
        int compareTo(E other);
    }

}
