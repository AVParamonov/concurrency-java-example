package com.avparamonov.concurrent.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class MultithreadingExampleJava8FJP {

    public static void main(String[] args) {
        List<String> threadNames = Arrays.asList("Thread 1", "Thread 2");

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<String> results = forkJoinPool.submit(() ->
                threadNames.parallelStream()
                        .map(threadName -> {
                            System.out.println("Thread " + threadName + " started.");

                            // Perform some task
                            for (int i = 1; i <= 5; i++) {
                                System.out.println("Thread " + threadName + " processing task " + i);

                                try {
                                    // Simulate some work
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            System.out.println("Thread " + threadName + " finished.");

                            return "Thread " + threadName + " completed.";
                        })
                        .collect(Collectors.toList())
        ).join();

        forkJoinPool.shutdown();

        System.out.println("All threads have been submitted.");

        // Print the results
        results.forEach(System.out::println);
    }
}
