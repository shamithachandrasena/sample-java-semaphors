package com.samsl.semaphors;

import java.util.concurrent.Semaphore;

public class Writer implements Runnable {
    private Semaphore semaphore;

    public Writer(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public void run() {
        try {
            semaphore.acquire();
            for(int i=0; i < 50000; i++)
            {
                System.out.println("Writer");
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
