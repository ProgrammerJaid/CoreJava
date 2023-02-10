package com.jacobjenkov.concurrency.executor;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskCancellation {

	public static void main(String[] args) {
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Future<String> f = ex.submit(ExecutorServiceExample.newCallable("Task 3.0"));
		System.out.println(f.isDone());
		
		f.cancel(true);		//may interrupt
		try {
			String res = f.get();
			System.out.println(res);
		}
		catch(InterruptedException | ExecutionException | CancellationException e) {
			System.err.println("Cannot get value from future.get() because task was cancelled.");
		}
		
		System.out.println(f.isDone());
		ex.shutdown();
	}
}
