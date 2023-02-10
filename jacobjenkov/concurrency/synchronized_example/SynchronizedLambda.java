package com.jacobjenkov.concurrency.synchronized_example;

import java.util.function.Consumer;

public class SynchronizedLambda {

	private static Object object = null;
	
	public static synchronized void  setObject(Object o) {
		object = o;
	}
	
	public static void consumeObject(Consumer consumer) {
		consumer.accept(object);
	}
	
	public static void main(String[] args) {
		
		consumeObject((obj)->{
			synchronized(SynchronizedLambda.class){
				System.out.println(obj);
			}
		});
		
		consumeObject((obj)->{					//We can use different object and not this class 
			synchronized (String.class) {		//however we won't have any effective blocking
				System.out.println(obj);		//as monitor objects are different.
			}
		});
	}
}
