package com.jacobjenkov.concurrency.threadlocal;

public class InheritableThreadLocalExample {

	public static void main(String[] args) {
		
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();
		
		Thread pThread = new Thread(()->{
			System.out.println("\n====In Parent Thread====");
			threadLocal.set("Thread 1- threadLocal");
			inheritableThreadLocal.set("Thread 1- InheritableThreadLocal");
			
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
			
			Thread cThread = new Thread(()->{
				System.out.println("\n====In child Thread====");
				System.out.println(threadLocal.get());		//cannot get this
				System.out.println(inheritableThreadLocal.get());	//can get this
			});
			
			cThread.start();
		});
		
		pThread.start();
		
		Thread thread2 = new Thread(()->{
			
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n====In Thread 2====");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});
		
		thread2.start();		//This thread has no relation with other threads(i.e., pThread) 
	}							//so it prints null
}
