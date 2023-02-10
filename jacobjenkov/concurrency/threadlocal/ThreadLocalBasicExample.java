package com.jacobjenkov.concurrency.threadlocal;

public class ThreadLocalBasicExample {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		
		Thread t1 = new Thread(()-> {
			threadLocal.set("Thread 1 saved value.");
			try {
				Thread.sleep(2000);
				System.out.println("In Thread 1: "+Thread.currentThread().getName());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			String val = threadLocal.get();
			System.out.println(val);
		});
		
		Thread t2 = new Thread(()->{
			threadLocal.set("Thread 2 saved value.");
			try {
				Thread.sleep(2000);
				System.out.println("In Thread 2: "+Thread.currentThread().getName());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			//threadLocal.remove();		removes the value visible to this thread.
			String val = threadLocal.get();
			System.out.println(val);
		});
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t1.start();
		t2.start();
		
	}
}
