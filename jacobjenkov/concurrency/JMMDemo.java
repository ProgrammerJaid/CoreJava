package com.jacobjenkov.concurrency;

public class JMMDemo implements Runnable {

	private int count = 0;

	@Override
	public void run() {
		
		DummyObject dumObj = new DummyObject();
		System.out.println("Object reference points to this location "+dumObj);
		
		for(int i=0;i<1_00_000;i++)
			this.count++;
		
		System.out.println(Thread.currentThread().getName()+" : "+this.count);
	}

}

/*
 * This dummy object is created inside run method and is not shared among threads whether 
 * same or different runnable objects are used.
 */
class DummyObject{}
