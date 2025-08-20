package com.example.demo.threadingQus;

public class Qus1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable thread1 = () -> System.out.println("Thread 1 is running");
        Thread t1 = new Thread(thread1);
        t1.start();

        Thread t2 = new Thread (()->{
            System.out.println("Thread 2 is running");
            try{
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 has finished sleeping");
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Main thread is ending");
    }
}
