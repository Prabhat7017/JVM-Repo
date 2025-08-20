package com.example.demo.threadingQus;

public class Qus2 {
    public static void main(String[] args) throws InterruptedException {

        synchronizedThread st= new synchronizedThread();
        Runnable runnable1 = () -> {
            for(int i = 0; i < 1000; i++) {
                st.increment();
            }
        };

        Runnable runnable2 = () -> {
            for(int i = 0; i < 1000; i++) {
                st.increment();
            }
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(st.getCount());
    }
}

class synchronizedThread {
    private int count = 0;
    private int count2= 0;
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void increment2() {
           synchronized (this){
                count2++;
           }
    }

    public int getCount2() {
        return count2;
    }
}
