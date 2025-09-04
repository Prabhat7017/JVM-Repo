package com.example.demo.threadingQus;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Qus6 {
    public static void main(String[] args) throws InterruptedException {
        SharedResource2 resourceA = new SharedResource2("ResourceA");
        SharedResource2 resourceB = new SharedResource2("ResourceB");
        Thread thread1 = new Thread(() -> {
            try {
                resourceA.lockResource(resourceB);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            try {
                resourceB.lockResource(resourceA);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class SharedResource2 {
    private final String name;
    Lock lock = new ReentrantLock();

    public SharedResource2(String name) {
        this.name = name;
    }

    public void lockResource(SharedResource2 sharedResource) throws InterruptedException {
        System.out.println("Attempting to lock " + name + " by " + Thread.currentThread().getName());

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(name + " locked by " + Thread.currentThread().getName());
                System.out.println("Thread " + Thread.currentThread().getName() + " is trying to lock " + sharedResource.name);
                if (sharedResource.lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println(sharedResource.name + " locked by " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } finally {
                        sharedResource.lock.unlock();
                        System.out.println(sharedResource.name + " unlocked by " + Thread.currentThread().getName());
                    }
                } else {
                    System.out.println("Failed to lock :)" + sharedResource.name + " by " + Thread.currentThread().getName());
                }
            } else {
                System.out.println("Failed to lock " + name + " by " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while locking resources: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}