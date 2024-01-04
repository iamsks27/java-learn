package com.shivam.learn.youtube;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue_UsingSynchronize<E> {

    private final int max;
    private final Queue<E> queue;
    private final Object notFull;
    private final Object notEmpty;

    public MyBlockingQueue_UsingSynchronize(int max) {
        this.max = max;
        this.queue = new LinkedList<>();
        this.notFull = new Object();
        this.notEmpty = new Object();
    }

    public synchronized void put(E e) throws InterruptedException {
        while (queue.size() == max) {
            notFull.wait();
        }
        queue.add(e);
        notEmpty.notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            notEmpty.wait();
        }
        E item = queue.remove();
        notFull.notifyAll();
        return item;
    }
}
