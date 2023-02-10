package com.semanticsqaure.concurrency;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MyFirstThread { // Prefer this approach

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task); // NEW
		thread.start();

		try {
			Thread.sleep(3000); 	//Can be used in WebCrawler
									// Disadvantage of using sleep is that it is in ms only so if we had to wait an
									// hour it would be difficult so we use TimeUnit to solve this problem
			SECONDS.sleep(3);
			//thread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Inside main ...");
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside Run...");
		try {
			SECONDS.sleep(9);
		} catch (InterruptedException e) {
			System.out.println("Interrupted...\n");
		}
		go();
	}

	private void go() {
		System.out.println("Inside go ...");
		more();
	}

	private void more() {
		System.out.println("Inside more ...");
	}
}
