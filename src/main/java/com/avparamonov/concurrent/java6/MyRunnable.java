package com.avparamonov.concurrent.java6;

public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " started.");

        // Perform some task
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + name + " processing task " + i);

            try {
                // Simulate some work
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread " + name + " finished.");
    }
}
