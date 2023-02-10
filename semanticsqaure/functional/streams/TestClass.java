package com.semanticsqaure.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

	public static void main(String[] args) {
		String s=leetCode451("tree");
		interviewQuestn("Orange Apple Orange Apple Lemon Lemon Lemon");
		System.out.println(s);
	}

	private static void interviewQuestn(String s) {
		
		String[] sp = s.split("[\\s]+");
		System.out.println(Arrays.toString(sp));
		
	}

	private static String leetCode451(String s) {
		
		char[] ch = s.toCharArray();
		
		Map<Character,Integer> mp = new HashMap<>();
		
		for(char c:ch)
			mp.put(c, mp.getOrDefault(c, 0)+1);
		
		Map<Integer,List<Character>> tm = new TreeMap<>(Collections.reverseOrder());
		
		for(char c:mp.keySet()) {
			
			if(!tm.containsKey(mp.get(c))) {
				List<Character> l = new ArrayList<>();
				l.add(c);
				tm.put(mp.get(c), l);
			}
			
			else {
				List<Character> list = tm.get(mp.get(c));
				list.add(c);
				tm.put(mp.get(c), list);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n:tm.keySet()) {
			List<Character> l = tm.get(n);
			for(char c:l)
				for(int i=0;i<n;i++)
					sb.append(c);
		}
		
		System.out.println(sb.toString());
		System.out.println(tm);
		
		String collect = 
			s.codePoints()
				.mapToObj(Character::toString)
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) //Accumulate Frequency
					.entrySet()
					.stream()
						.sorted(Map.Entry.<String,Long>comparingByValue().reversed()) //Sort Descending by frequency
							.map(e -> e.getKey().repeat(e.getValue().intValue())) //Expand the letter
								.collect(Collectors.joining());
		
		return collect;
	}
	
}
