package com.semanticsqaure.concurrency;

public class ThreadPriorityDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());		//It will give ref to main Thread
		System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName());
		
		Thread t1 = new Thread(new EmailCampaign());
		Thread t2 = new Thread(new DataAggregator());
		
		t1.setName("EmailCampaign");
		t2.setName("DataAggregator");
		
		t1.setPriority(Thread.MIN_PRIORITY );
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
		try {
			// main thread is suspended until t2 DIES
			t2.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Inside main ... ");
	}
}

class EmailCampaign implements Runnable {
	@SuppressWarnings("static-access")
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			if (i == 5) {
				// Hint to scheduler that thread is willing to 
				// yield its current use of CPU
				Thread.currentThread().yield();
			}
        }		
	}
}

class DataAggregator implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
        }
	}
}
