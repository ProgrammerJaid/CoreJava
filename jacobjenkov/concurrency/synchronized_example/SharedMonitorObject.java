package com.jacobjenkov.concurrency.synchronized_example;

public class SharedMonitorObject {

	private Object monitor = null;
	
	private int counter = 0;

	public SharedMonitorObject(Object monitor) {
		if(monitor==null)
			throw new IllegalArgumentException("Monitor object cannot be null.");
		
		this.monitor=monitor;
	}
	
	public void incCounter() {
		synchronized (monitor) {
			this.counter++;
		}
	}
}
