package com.example.demo.threadingQus;

import java.util.concurrent.*;

class RandomIntegerGenerator implements Callable<Integer> {
    private int min;
    private int max;

    public RandomIntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
public class Qus8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(1, 100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(generator);
        System.out.println(future1.get());

        executorService.shutdown();
    }
}
