package com.semanticsqaure.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
	  private static volatile boolean stop;			//If we remove volatile the process will become luck dependent...

	  public static void main(String[] args) throws InterruptedException {
		  new Thread(new Runnable() {
	      public void run() {
	          while(!stop) { System.out.println("In while ..."); }
	          }
	      }).start();

	      TimeUnit.SECONDS.sleep(1);
	      stop = true; 
	 }
}
