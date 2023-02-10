package com.semanticsqaure.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	
	private static void hashMapDemo() {
		System.out.println("\n\nHash Map Demo ...");
		Map<String, Integer> map1=new HashMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", null);
		System.out.println(map1);
		
		map1.put("Anita", 23);
		System.out.println(map1);
		
		System.out.println("Contains John? "+ map1.containsKey("John"));
		System.out.println("John's age "+ map1.get("John"));
		
		System.out.println("\nIterating using keySet ...");
		Set<String> names = map1.keySet();
		for(String name:names) {
			System.out.println("Name: "+name+",Age: "+map1.get(name));
		}
		
		System.out.println("\nIterating using entrySet ...");
		Set<Map.Entry<String,Integer>> mappings = map1.entrySet();
		for(Map.Entry<String,Integer> mapping:mappings) {
			System.out.println("Name: "+mapping.getKey()+",Age: "+mapping.getValue());
		}
		
		names.remove("Anita");
		System.out.println("\n"+map1);
		
		//Creating complex map ...
		
		Map<String, Map<String, Object>> userProfile = new HashMap();		//Nested Map
		
		Map<String, Object> profile =new HashMap();
		profile.put("age", 25);
		profile.put("dept", "EE");
		profile.put("city", "Chennai");
		
		userProfile.put("John", profile);
		
		profile=new HashMap<>();
		profile.put("age", 29);
		profile.put("dept", "EE");
		profile.put("city", "Delhi");
		userProfile.put("Raj", profile);
		
		System.out.println("\n\nuserProfile:"+ userProfile);
		
		Map<String, Object> profile1=userProfile.get("John");
		int age=(int) profile1.get("age");//downcast because it returns object
		System.out.println(age);
		
		//TODO:Try using second constructor,putAll ,clear,values and other methods
	}
	
	public static void main(String[] args) {
		//hashMapDemo();
		//immutableKeyDemo();
		//lruCacheTest();
		treeMapDemo();
	}

	 /*
	   * Demo: 
	   * 	1. See output with and without commenting get() calls
	   *    2. See output when accessOrder=false with get() calls. get calls do not have any influence
	   *    3. Finally, change object type from LRUCache to LinkedHashMap and see output. 
	   *       All 5 mappings will be printed as removeEldestEntry would return false by default
	   */
	
	private static void lruCacheTest() {
		System.out.println("\n\nInside lruCacheTest ...");
		Map<String, String> lruCache = new LRUCache(16,0.75f,true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		
		lruCache.get("a");
		lruCache.get("a");
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
	}
	
	private static void treeMapDemo() {
		System.out.println("\n\nInside treeMapDemo ...");
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", 23);
		
		System.out.println(map1);	
		
		System.out.println("Iterating using entrySet ...");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
			if (mapping.getKey().equals("John"))
				mapping.setValue(26);	
		}
		System.out.println(map1);
		//map1.floorEntry("Raj").setValue(22);	//UnsupportedOperationException due to floor entry ceiling entry
	}

	private static void immutableKeyDemo() {
		System.out.println("\n\nInside ImmutableKeysDemo ... ");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		
		list.add(2);		//Mutating list
		System.out.println(map.get(list));	//It gives null because of abstract class implemented by arrayList check notes
		
		Student s = new Student(1,null);
		Map<Student,Integer> map2 = new HashMap<>();
		map2.put(s, 1);
		
		s.setName("John");
		System.out.println(map2.get(s));	//It gives 1 because student class did not override hashcode or equals method
	}
}

class LRUCache<K,V> extends LinkedHashMap<K,V>{
	//private static final long serialVersionUID = 6464155743798737431L;
		private static final int MAX_ENTRIES = 3;
		  
		public LRUCache(int initialCapacity,
		             float loadFactor,
		             boolean accessOrder) {
			 super(initialCapacity, loadFactor, accessOrder);
		}
		  
		// Invoked by put and putAll after inserting a new entry into the map
		public boolean removeEldestEntry(Map.Entry eldest) {
		     return size() > MAX_ENTRIES;
			 // return false; // same as normal linked hash map
		}	
}

class Student{
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student(int id, String name) {
		super();
		this.id=id;
		this.name=name;
	}
}
