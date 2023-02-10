package com.jacobjenkov.concurrency;

public class ThreadExample8 {

	public static class  StoppableRunnable implements Runnable{

		private boolean stopRequested = false;
		
		public synchronized void stopRequest() {
			this.stopRequested=true;
		}
		
		public synchronized boolean isStopRequested() {
			return this.stopRequested;
		}
		
		private void sleep(long millis) {
			try {
				Thread.sleep(millis);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			System.out.println("\nStoppableRunnable Running");
			while(!isStopRequested()) {
				sleep(1000);
				System.out.println("...");
			}
			System.out.println("StoppableRunnable Stopped.");
		}
		
		public static void main(String[] args) {
			
			StoppableRunnable stoppableRunnable = new StoppableRunnable();
			Thread t1 = new Thread(stoppableRunnable, "Temporary thread.");
			t1.start();
			
			try {
				Thread.sleep(5000);	//main thread will sleep for 5 secs
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Requesting stoping of temporary thread.");
			stoppableRunnable.stopRequest();
			System.out.println("Stop requested.");
		}
	}
}
