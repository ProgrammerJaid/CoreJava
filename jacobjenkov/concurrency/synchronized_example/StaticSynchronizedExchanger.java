package com.jacobjenkov.concurrency.synchronized_example;

/*
 *Similar to SynchronizedExchanger,this only has methods same as before just 
 *static keyword associated with it. 
 */

public class StaticSynchronizedExchanger {

	private static Object obj = null;
	
	public static synchronized void setObject(Object o) {
		obj = o;
	}
	
	public static Object getObject() {
		return obj;
	}
	
	public static synchronized void setObj(Object o) {
		synchronized (StaticSynchronizedExchanger.class) {
			obj = o;
		}
	}
	
	public static Object getObj() {
		synchronized (StaticSynchronizedExchanger.class) {
			return obj;
		}
	}
}
