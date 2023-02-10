package com.jacobjenkov.concurrency.synchronized_example;

public class TestClass {

	public static void main(String[] args) {
		
//		SynchronizedExchanger syncExchanger = new SynchronizedExchanger();
//		
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int i=0;i<1000;i++)
//					syncExchanger.setObject(""+i);
//			}
//		});
//		
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int i=0;i<1000;i++)
//					System.out.println(syncExchanger.getObject());
//			}
//		});
//		
//		t1.start();
//		t2.start();
		
		Object monitor1 = new Object();
		SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
		SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
		
		smo1.incCounter();
		smo2.incCounter();
		
		Object monitor2 = new Object();
		SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
		
		smo3.incCounter();
		
	}
}
