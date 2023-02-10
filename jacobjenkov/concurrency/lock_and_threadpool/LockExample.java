package com.jacobjenkov.concurrency.lock_and_threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static void main(String[] args) {
		// lockBasics();
		// lockInterruptibly();
		// tryLock();
		extraMethods();
	}

	private static void lockBasics() {
		Lock lock = new ReentrantLock(false);

		Runnable runnable = () -> {
			lockSleepUnlock(lock, 1000);
		};

		Thread thread1 = new Thread(runnable, "Thread 1");
		Thread thread2 = new Thread(runnable, "Thread 2");
		Thread thread3 = new Thread(runnable, "Thread 3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

	private static void lockInterruptibly() {
		Lock lock = new ReentrantLock();
		Thread.currentThread().interrupt();
		try {
			lock.lockInterruptibly();
			lock.unlock();
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted");
		}
	}

	private static void tryLock() {
		Lock lock = new ReentrantLock();
		try {
			boolean lockStatus = lock.tryLock();
			System.out.println("Lock Status: " + lockStatus);
		} finally {
			lock.unlock();
		}
	}

	private static void extraMethods() {

		ReentrantLock rLock = new ReentrantLock();
		int holdCount = rLock.getHoldCount();// gives how many times current thread has locked this lock
		int qLen = rLock.getQueueLength();
		boolean hasQueuedThread = rLock.hasQueuedThread(Thread.currentThread());// gives current thread trying to lock
																				// this lock
		boolean hasQueuedThreads = rLock.hasQueuedThreads();
		boolean fair = rLock.isFair();
		boolean isLocked = rLock.isLocked();
		boolean heldByCurrentThread = rLock.isHeldByCurrentThread();
	}

	private static void lockSleepUnlock(Lock lock, long millis) {

		try {
			lock.lock(); // first thread who lock gets first served if fairness is applied
			System.out.println(Thread.currentThread().getName() + " holds the lock.");
			sleep(millis);
		} finally {
			lock.unlock();
		}
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
