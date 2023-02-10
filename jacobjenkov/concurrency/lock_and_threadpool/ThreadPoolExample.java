package com.jacobjenkov.concurrency.lock_and_threadpool;

public class ThreadPoolExample {

	public static void main(String[] args) throws Exception {

		ThreadPool threadPool = new ThreadPool(3, 10); // takes no. of threads and no. of task.

		for (int i = 0; i < 10; i++) {

			int taskNo = i;
			threadPool.execute(() -> {
				String message = Thread.currentThread().getName() + ": Task " + taskNo;
				System.out.println(message);
			});
		}

		threadPool.waitUntilAllTasksFinished(); // this forces threadPool to perform the loaded task 
												// even if stop is called
		threadPool.stop();
	}
}
