package com.jacobjenkov.concurrency.synchronized_example;

public class MixedSynchronization {

	public static Object staticObj = null;
	
	public static synchronized void setStaticObj(Object obj) {
		staticObj=obj;
	}
	
	public Object instanceObject = null;
	
	public void setInstanceObject(Object obj) {
		this.instanceObject=obj;
	}
}
