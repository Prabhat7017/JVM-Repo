package com.example.demo.threadingQus;

public class Qus3 {
    public static void main(String[] args) {
        VolatileFlag volatileFlag = new VolatileFlag();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is waiting for the flag to be set.");
            while (!volatileFlag.isFlag()) {
                // Busy-waiting
            }
            System.out.println("Thread 1 finished waiting.");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is doing some work.");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileFlag.setFlag(true); // Set the flag to true to notify thread1
            System.out.println("Thread 2 finished work and set flag to true.");
        });
        thread2.start();


    }
}

class VolatileFlag {
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}