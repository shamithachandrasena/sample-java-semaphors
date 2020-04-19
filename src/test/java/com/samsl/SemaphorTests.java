package com.samsl;

import com.samsl.semaphors.*;
import org.junit.Test;

import java.util.concurrent.Semaphore;

public class SemaphorTests {
	@Test
	public void testSemaphorDemo() {
		try {
			SemaphoreDemo.main(new String[1]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
	}

	@Test
	public void testSemaphors() throws InterruptedException {
		Semaphore sem = new Semaphore(1);

		// creating two threads with name A and B
		// Note that thread A will increment the count
		// and thread B will decrement the count
		Runnable reader = new Reader(sem);
		Runnable writer = new Writer(sem);
		Thread readerThread = new Thread(reader);
		Thread writerThread = new Thread(writer);

		// stating threads A and B

		readerThread.start();
		writerThread.start();

		// waiting for threads A and B
		readerThread.join();
		writerThread.join();

	}
}
