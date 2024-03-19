package com.shivam.learn.youtube;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue_UsingLock<E> {

    private final int max;
    private final Queue<E> queue;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public MyBlockingQueue_UsingLock(int max) {
        this.max = max;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock(true);
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(E e) {
        lock.lock();
        try {
            while (queue.size() == max) {
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            throw new RuntimeException("Error while adding a value in the queue");
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error in reading the value from the queue");
        } finally {
            lock.unlock();
        }
    }
}
