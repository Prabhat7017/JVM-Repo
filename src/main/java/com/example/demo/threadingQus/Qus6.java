package com.example.demo.threadingQus;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Qus6 {
    public static void main(String[] args) throws InterruptedException {
        SharedResource2 resourceA = new SharedResource2();
        SharedResource2 resourceB = new SharedResource2();
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

    Lock lock = new ReentrantLock();
    public void lockResource(SharedResource2 sharedResource) throws InterruptedException {
        System.out.println("Attempting to lock resource by " + Thread.currentThread().getName());

        try {
        if(lock.tryLock(1, TimeUnit.SECONDS)){
            System.out.println("Resource locked by " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("Thread " + Thread.currentThread().getName() + " is trying to lock to lock other resource.");
            if(sharedResource.lock.tryLock(1, TimeUnit.SECONDS)){
                System.out.println("Other resource locked by " + Thread.currentThread().getName());
                try {
                    // Simulate some work with the locked resources
                    Thread.sleep(1000);
                } finally {
                    sharedResource.lock.unlock();
                    System.out.println("Other resource unlocked by " + Thread.currentThread().getName());
                }
        }else{
                System.out.println("Failed to lock other resource by " + Thread.currentThread().getName());
            }
        }else{
            System.out.println("Failed to lock resource by " + Thread.currentThread().getName());
        }}catch (Exception e) {
            System.out.println("Exception occurred while locking resources: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void releaseResource() {
        System.out.println("Resource released by " + Thread.currentThread().getName());
    }
}