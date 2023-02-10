package com.semanticsqaure.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		dequeTest();
		Queue<Integer> q = new PriorityQueue<>();
	}

	private static void dequeTest() {
		System.out.println("\nInside dequeTest ...");
		
		//Queue - FIFO
		Deque<String> deque = new ArrayDeque<>();	//Use ArrayDeque<> recommended approach
		deque.add("walden");
		deque.add("harry potter");
		deque.add("Head first Java");
		
		System.out.println("\nPrinting Queue ...");
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		
		//Stack -LIFO
		//Using the same deque as stack as deque is empty
		deque.push("walden");
		deque.push("harry potter");
		deque.push("Head first Java");
		
		System.out.println("\nPrinting Stack ...");
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		System.out.println(deque.pop());
	}
}
