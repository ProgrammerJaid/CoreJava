package com.jacobjenkov.concurrency.lock_and_threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {

	public static void main(String[] args) {
		
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		
		Runnable r1 = new Deadlock1(lock1,lock2);
		Runnable r2 = new DeadLock2(lock1, lock2);
		
		Thread t1 = new Thread(r1);
		t1.setName("Thread 1");
		Thread t2 = new Thread(r2);
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}
