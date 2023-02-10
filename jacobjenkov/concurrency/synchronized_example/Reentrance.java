package com.jacobjenkov.concurrency.synchronized_example;

public class Reentrance {

	private int count = 0;
	
	public synchronized void inc() {
		this.count++;
	}
	
	public synchronized int incAndGet() {
		inc();					//it allows to call another synchronized method 
		return this.count;		//within synchronized method with same monitor object.	
	}
}
