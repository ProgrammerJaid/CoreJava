package com.jacobjenkov.concurrency.synchronized_example;
/*
 * Synchronized keyword 
 */
public class SynchronizedExchanger {

	protected Object obj = null;

	public synchronized void setObject(Object obj) {
		this.obj = obj;
	}

	public synchronized Object getObject() {
		synchronized (this) {
			return obj;
		}
	}

	public void setObj(Object obj) {
		synchronized (this) {
			this.obj = obj;
		}
	}
	
	public Object getObj() {
		synchronized (this) {
			return this.obj;
		}
	}

}
