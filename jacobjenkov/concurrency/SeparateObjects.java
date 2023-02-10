package com.jacobjenkov.concurrency;
/*
 * In this example each thread is given a new Runnable Object(i.e., new JMMDemo())
 * so they have there own count variable
 * in heap.
 */
public class SeparateObjects {

	public static void main(String[] args) {
		
		Runnable run1 = new JMMDemo();	
		Runnable run2 = new JMMDemo();
		Thread t1 = new Thread(run1, "Thread 1");	
		Thread t2 = new Thread(run2, "Thread 2");
		t1.start();
		t2.start();
	}
}
