package com.gpetuhov.rxjava.callbacks;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread start");

        Runnable runnable = () -> {
            Main main = new Main();
            main.runningAsync(new Callback() {
                @Override
                public void pushData(double result) {
                    System.out.println("Result = " + result);
                }

                @Override
                public void pushError(Exception ex) {
                    System.out.println("Error: " + ex);
                }

                @Override
                public void pushComplete() {
                    System.out.println("All calculations complete");
                }
            });
        };

        Thread thread = new Thread(runnable);
        thread.start();

        // Wait for background thread
        thread.join();

        System.out.println("Main thread complete");
    }

    public void runningAsync(Callback callback) {
        System.out.println("Background thread start");

        for (int i = 0; i < 5; i++) {
            try {
                double result = calculate();
                callback.pushData(result);
            } catch (InterruptedException e) {
                callback.pushError(e);
            }
        }

        callback.pushComplete();
    }

    private double calculate() throws InterruptedException {
        // Mock calculations
        Thread.sleep(1000);
        return Math.random();
    }
}
