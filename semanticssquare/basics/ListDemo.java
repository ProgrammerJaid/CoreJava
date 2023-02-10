package com.semanticssquare.basics;
import java.util.*;

public class ListDemo {

	/*private static List<Integer> arrayListDemo() {
		
		/*Collection<Integer> list1 = new ArrayList<>();//soln.to over come 
		list1.add(1); //method signature binding is using list,it will remove null.
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		//System.out.println("list1: "+list1);
		
		list1.remove(3);//it tries to find 3 and remove it
		//System.out.println("list1: "+list1);
		list1.remove(3);//due to method binding 3 is removed not null
		//System.out.println("list1: "+list1);*/
		
		/*List<Integer> list2 = new ArrayList<>();//soln.to over come 
		list2.add(1); //method signature binding is using list,it will remove null.
		list2.add(2);
		list2.add(3);
		list2.add(3);
		list2.add(null);
		//System.out.println("list1: "+list2);
		
		list2.remove(3);//it removes 3rd element
		//System.out.println("list1: "+list2);
		list2.remove(3);//it removes 3rd element
		//System.out.println("list1: "+list2);
		
		list2.add(0,10);
		//System.out.println("list1: "+list2);
		//int a=list2.set(0,9);//it returns previous value at that index.
		System.out.println("list2: "+list2);
		//System.out.println("list1: "+a);
		
		
		//Bulk Operations
		Collection<Integer> list3 = new ArrayList<>();
		list3.add(9);
		list3.add(3);
		
		list2.removeAll(list3);//remove 9 and 3 from list2 if exist.
		System.out.println("list2 "+list2);
		list3.add(1);
		
		list2.retainAll(list3);//it will retain only 1 and remove all other
		System.out.println("list2: "+list2);
		
		list2.addAll(list3);
		System.out.println("list2: "+list2);
		System.out.println("list2.set(2,2) "+list2.set(2,2));//it replaces 3 with 2 and it returns previous value
		
		//Search
		System.out.println("list2.contains(1): "+list2.contains(1));
		System.out.println("list2.indexOf(1): "+list2.indexOf(1));
		System.out.println("list2.lastIndexOf(1) "+list2.indexOf(1));
		System.out.println("list2: "+list2);
		
		*/
		
		//Range-view: sublist(new list is backed by orignal)
		/*List<Integer> list4=list2.subList(2,3);
		list4.set(0, 6);//this does not effect orignal list
		System.out.println("list2: "+list2);
		list4.add(0,7);//this get reflected in orignal list
		System.out.println("list2: "+list2);
		//in list2 we can set,but we cannot change sub array it will throw exception(the backed array will).
		
		/*for(int element:list2) {
			System.out.println("element "+element);
			
			//Generates ConcurrentModificationException 
			if(element==9)
				list2.remove(Integer.valueOf(element));//valueOf is used due t its capacity
		}*/
		
		//return list2;
	
	/*private static void iteratorDemo(List<Integer> list1) {
		
		System.out.println("\nInside IteratorDemo...");
		
		Iterator<Integer> it = list1.iterator();
		while(it.hasNext()) {
			int ele =it.next();
			System.out.println("element: "+ele);
			
			if(ele == 9)
				it.remove();
		}
		
		System.out.println("list1: "+list1);
		
		list1.forEach(System.out::println);//method reference  
	}*/
	
	private static void dequeDemo() {
		
		Deque<Integer> d = new ArrayDeque<>();
		d.add(3);
		d.add(5);
		d.add(7);
		
		System.out.println("\nPrinting Queue ...");
		System.out.println(d.remove()); // removeFirst
		System.out.println(d.remove());
		System.out.println(d.remove());
		
		}
	public static void main(String[] args) {
		
		//List<Integer> list1=arrayListDemo();
		//iteratorDemo(list1);
		dequeDemo();
	}
}
