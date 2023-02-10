package com.jacobjenkov.concurrency;
/*
 * Here same instance of Runnable(JMMDemo) is shared between two threads,
 * so they have same count instance variable pointer shared among themselves.
 */
public class SharedObject {

	public static void main(String[] args) {
		Runnable run = new JMMDemo();
		
		Thread t1 = new Thread(run,"Thread 1");
		Thread t2 = new Thread(run,"Thread 2");
		t1.start();
		t2.start();
	}
}
