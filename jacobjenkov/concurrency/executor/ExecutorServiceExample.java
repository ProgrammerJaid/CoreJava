package com.jacobjenkov.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
//		executorsDemo();
//		threadPoolExecutorSyntax();
//		threadPoolWithFuture();
//		invokeAnyMethod();
//		invokeAllMethod();
	}

	private static void executorsDemo() {
		ExecutorService executorService = 
				Executors.newFixedThreadPool(10);
		
		executorService.execute(newRunnable("Task 1"));
		executorService.execute(newRunnable("Task 2"));
		executorService.execute(newRunnable("Task 3"));
		
		executorService.shutdown();
	}
	
	private static void threadPoolExecutorSyntax() {
		int corePoolSize = 10;	//basic pool size
		int maxPoolSize = 20;	//for more task thread can increase
		long keepAliveTime = 3000;	//if thread not part of core pool thread if idle terminate
		
		ExecutorService threadPoolExecutor = new 
				ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
						TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(128));
		
		threadPoolExecutor = Executors
						.newFixedThreadPool(3);	//creates thread pool with fixed size i.e. 3 
		
		threadPoolExecutor.shutdown();
	}
	
	private static void threadPoolWithFuture() {
		
		ExecutorService executorService = 
				Executors.newFixedThreadPool(1);
		
		Future future = executorService.submit(newRunnable("Task 1.1"));
		
		System.out.println(future.isDone());
		
		try {
			future.get();	//it returns null because Runnable is void
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		
		System.out.println(future.isDone()+"\n\n\n");
		
		executorService.shutdown();
		
		ExecutorService exeService = Executors.newSingleThreadExecutor();
		Future<String> submit = exeService.submit(newCallable("FutureTask 1.2"));
		try {
			System.out.println(submit.isDone()+" "+submit.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(submit.isDone());
		exeService.shutdown();
	}


	private static void invokeAnyMethod() {
		/*
		 * If we have multiple server and we want one result from any server then we can
		 * use invokeAny that will fetch result and cancel all other task
		 */
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(newCallable("Task 2.1"));		//say server 1
		callables.add(newCallable("Task 2.2"));		// server 2
		callables.add(newCallable("Task 2.3"));		// server 3
		
		try {
			String res = executorService.invokeAny(callables);
			System.out.println("Result : "+res);
		}
		catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
	

	private static void invokeAllMethod() {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		List<Callable<String>> callables = new ArrayList<>();
		callables.add(newCallable("Task 2.1"));		
		callables.add(newCallable("Task 2.2"));		
		callables.add(newCallable("Task 2.3"));
		
		try {
			List<Future<String>> results = executorService.invokeAll(callables);
			
			for(Future<String> future:results)
				System.out.println(future.get());
		}
		catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
	
	private static Runnable newRunnable(String msg) {
		return new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" : "+msg);
				
			}
		};
	}
	
	public static Callable<String> newCallable(String msg) {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				return Thread.currentThread().getName()+" : "+ msg;
			}
		};
	}
	
}
