package com.example.demo.threadingQus;

import java.util.concurrent.*;

class CallableDemo implements Callable<Long> {
    private int number;

    public CallableDemo(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        Long fact = 1L;
        for (int i=number; i>=1; i--) {
            fact*=i;
        }
        return fact;
    }
}
public class Qus5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo(5);
//        Thread thread = new Thread(callableDemo);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> res = executorService.submit(callableDemo);
        System.out.println("Factorial of 5 is: " + res.get());

        executorService.shutdown();
    }

}
