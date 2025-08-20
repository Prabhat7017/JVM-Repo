package com.example.demo.threadingQus;

public class Qus4 {
    public static void main(String[] args) {
        SharedResource resourceA = new SharedResource();
        SharedResource resourceB = new SharedResource();
        Thread thread1 = new Thread(() -> {
            resourceA.lockResource(resourceB);
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            resourceB.lockResource(resourceA);
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}

class SharedResource {
    public synchronized void lockResource(SharedResource sharedResource) {
        System.out.println("Resource locked by " + Thread.currentThread().getName());
        sharedResource.releaseResource();
    }

    public synchronized void releaseResource() {
        System.out.println("Resource released by " + Thread.currentThread().getName());
    }
}
