package com.avparamonov.concurrent.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultithreadingExampleJava8 {

    public static void main(String[] args) {
        List<String> threadNames = Arrays.asList("Thread 1", "Thread 2");

        List<Thread> threads = threadNames.stream()
                .map(threadName -> new Thread(() -> {
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
                }))
                .collect(Collectors.toList());

        // Start the threads
        threads.forEach(Thread::start);

        // Wait for the threads to finish
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("All threads have finished execution.");
    }
}
