package com.example.demo.threadingQus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int counter =10;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void setCounter(){
        writeLock.lock();
        try {
            counter++;
            System.out.println("Counter incremented by "+Thread.currentThread().getName() + counter);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock();
        }
    }
    public void getCounter(){
        System.out.println("Attempting to acquire read lock... "+ Thread.currentThread().getName());
        readLock.lock();
        try {
            System.out.println("Counter value by "+Thread.currentThread().getName() + counter);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();

        // Create multiple threads to read the counter
        for (int i = 0; i < 5; i++) {
            new Thread(example::setCounter).start();
        }
    }

}
