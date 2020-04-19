package com.samsl.semaphors;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {
    private Semaphore semaphore;

    public Reader(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            for(int i=0; i < 50000; i++)
            {
                System.out.println("Reader");
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
