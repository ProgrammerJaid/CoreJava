package com.jacobjenkov.concurrency.threadlocal;

public class ThreadLocalInitialValue {

	public static void main(String[] args) {
		
		ThreadLocal<MyObject> threadLocal0 = ThreadLocal.
				withInitial(()->new MyObject());
		
		ThreadLocal<MyObject> threadLocal1 = ThreadLocal.
				withInitial(()->new MyObject());
		
		ThreadLocal<String> lazyLoadingThreadLocal = new ThreadLocal<String>();
		String val = lazyLoadingThreadLocal.get();
		if(val==null) {
			lazyLoadingThreadLocal.set("Value is lazy loaded");
			val = lazyLoadingThreadLocal.get();
		}
		
		System.out.println(val);
		
		Thread t1 = new Thread(()->{
			System.out.println(threadLocal0.get()+" "+Thread.currentThread().getName());
			System.out.println(threadLocal1.get()+" "+Thread.currentThread().getName());
		});
		
		Thread t2 = new Thread(()->{
			System.out.println(threadLocal0.get()+" "+Thread.currentThread().getName());
			System.out.println(threadLocal1.get()+" "+Thread.currentThread().getName());
		});
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t1.start();
		t2.start();
	}
}

class MyObject{}