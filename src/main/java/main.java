import com.example.demo.pojo.UserDetails;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello, World!");
//
//        Runnable newThread = ()->{
//            System.out.println("This is thread 1");
//            try {
//                Thread.sleep(2000); // Sleep for 2 seconds
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread 1 has finished sleeping");
//        };
//        Thread thread1 = new Thread(newThread);
//        thread1.setDaemon(true);
//        thread1.start();
//
//        Thread thread2= new Thread(()->{
//            System.out.println("This is thread 2");
//        });
//        thread2.start();
//        System.out.println("Main thread is Ending");

//        sharedValiable share= new sharedValiable();
//       Thread t1=  new Thread(()->{
//            System.out.println("Thread 1 is running");
//            try{
//                Thread.sleep(100);// Sleep for 2 seconds
//                share.setFlag(true);
//                System.out.println("Thread 1 has finished sleeping and set flag to true");
//            }catch (InterruptedException e){
//                System.out.println("Thread 1 interrupted");
//            }


//            for (int i = 0; i < 50000; i++) {
//                share.incrementCounter();
//            }
//            System.out.println("Thread 1 has finished incrementing the counter");
//        });
//        t1.start();
//
//        Thread t2= new Thread(()->{
//            System.out.println("Thread 2 is running");
//            while (!share.isFlag()) {
////                System.out.println("Thread 2 is waiting for Thread 1 to finish");
//            }
//            System.out.println("Thread 2 has detected that Thread 1 has finished");

//            for (int i = 0; i < 50000; i++) {
//                share.incrementCounter();
//            }
//            System.out.println("Thread 2 has finished incrementing the counter");
//        });
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//
//        System.out.println(share.getCounter());


//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); // Using a single-threaded executor for demonstration
//        System.out.println("Starting the single-threaded executor...");
//        for (int i = 0; i < 5; i++) {
//            final int taskNumber = i;
//            singleThreadExecutor.execute(() -> {
//                System.out.println("Executing task " + taskNumber + " in thread " + Thread.currentThread().getName());
//            });
//        }
//        singleThreadExecutor.shutdown(); // Shutdown the executor after tasks are submitted


//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); // Using a fixed thread pool with 3 threads
//        System.out.println("Starting the fixed thread pool executor...");
//        for (int i = 0; i < 5; i++) {
//            final int taskNumber = i;
//            fixedThreadPool.execute(() -> {
//                System.out.println("Executing task " + taskNumber + " in thread " + Thread.currentThread().getName());
//            });
//        }
//        fixedThreadPool.shutdown();
//    }


//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // Using a cached thread pool
//        System.out.println("Starting the cached thread pool executor...");
//        for (int i = 0; i < 5; i++) {
//            final int taskNumber = i;
//            cachedThreadPool.execute(() -> {
//                System.out.println("Executing task " + taskNumber + " in thread " + Thread.currentThread().getName());
//            });
//        }
//        cachedThreadPool.shutdown(); // Shutdown the executor after tasks are submitted

//
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2); // Using a scheduled thread pool with 2 threads
//        System.out.println("Starting the scheduled thread pool executor...");
//        for (int i = 0; i < 5; i++) {
//            final int taskNumber = i;
//            scheduledThreadPool.execute(() -> {
//                System.out.println("Executing task " + taskNumber + " in thread " + Thread.currentThread().getName());
//            });
//        }
//        scheduledThreadPool.shutdown(); // Shutdown the executor after tasks are submitted


//
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
//
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//
//        Thread producerThread = new Thread(producer);
//        Thread consumerThread = new Thread(consumer);
//        producerThread.start();
//        consumerThread.start();


//        UserDetails userDetails = new UserDetails.builder()
//                .setAge(13)
//                .setName("John Doe")
//                .setEmail("fuguyge@kjf.com").build();

//        UserDetails userDetails = UserDetails.builder()
//                                    .age(13)
//                                    .name("Prabhat")
//                                    .build();
//
//        System.out.println(userDetails);


//        record Person(String name, int age){}
//        Person person = new Person("John", 30);
//        person.name= "Doe"; // This line will cause a compilation error because records are immutable
//        person.age = 31; // This line will also cause a compilation error because records are
//        System.out.println("Name: " + person.name() + ", Age: " + person.age());


//        Object[] objects = {"Hello", 132, 12.5, true, 'A'};
//        for (Object obj : objects) {
//            if (obj instanceof String) {
//                System.out.println("String: " + obj);
//            } else if (obj instanceof Integer) {
//                System.out.println("Integer: " + obj);
//            } else if (obj instanceof Double) {
//                System.out.println("Double: " + obj);
//            } else if (obj instanceof Boolean) {
//                System.out.println("Boolean: " + obj);
//            } else if (obj instanceof Character) {
//                System.out.println("Character: " + obj);
//            } else {
//                System.out.println("Unknown type: " + obj);
//            }
//        }

//        for (Object obj: objects){
//            switch (obj){
//                case String s -> System.out.println("String: " + s);
//                case Integer i -> System.out.println("Integer: " + i);
//                case Double d -> System.out.println("Double: " + d);
//                case Boolean b -> System.out.println("Boolean: " + b);
//                case Character c -> System.out.println("Character: " + c);
//                default -> System.out.println("Unknown type: " + obj);
//            }
//        }

//
//        Runnable runnable = () -> {
//            try {
//                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
//                Thread.sleep(10000);
//                System.out.println("Thread " + Thread.currentThread().getName() + " has finished");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        for (int i=0; i<100000; i++){
//            new Thread(runnable).start();
//        }

//        for (int i=0; i<100000; i++){
//            Thread.startVirtualThread(runnable);
//        }


        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i=0; i<100000; i++){
                executor.submit(()->{
                    try {
                        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                        Thread.sleep(10000);
                        System.out.println("Thread " + Thread.currentThread().getName() + " has finished");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    public static class sharedValiable {
        private volatile boolean flag = false;
        int counter = 0;
        private AtomicInteger atomicCounter = new AtomicInteger(0);
//        public synchronized boolean isFlag() {
//            return flag;
//        }

        public void incrementCounter() {
//            atomicCounter.incrementAndGet();
            synchronized (this) {
                counter++;
            }
//            counter++;
        }
        public int getCounter() {
//            return atomicCounter.get();
            return counter;
        }


//        public synchronized void setFlag(boolean flag) {
//            this.flag = flag;
//        }
    }
}


 class Producer implements Runnable{

    private BlockingQueue<Integer> ProducerQueue;

    public Producer(BlockingQueue<Integer> ProducerQueue) {
        this.ProducerQueue = ProducerQueue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Produced: " + i);
                ProducerQueue.put(i);

                Thread.sleep(100); // Simulate time taken to produce an item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
    }
}

class Consumer implements Runnable{

    private BlockingQueue<Integer> ConsumerQueue;

    public Consumer(BlockingQueue<Integer> ConsumerQueue) {
        this.ConsumerQueue = ConsumerQueue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Integer item = ConsumerQueue.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(150); // Simulate time taken to consume an item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted");
        }
    }
}
