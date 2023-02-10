package com.semanticsquare.generics;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo<T /* extends List & Serializable */> {

	// Generic Constructors are rare!!
	// <E extends T> GenericsDemo(E object) { }
	// <E> GenericsDemo(E object) {}
	GenericsDemo(T object) {
	}

	<E extends T> GenericsDemo() {
	}

	public static void main(String[] args) {
		/*Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println(stringStore.get());

		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println(integerStore.get());

		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1, 2, 3));
		System.out.println(listStore.get());

		List<Number> list = new ArrayList<>();
		list.add(1);
		list.add(2.2);
		// list.add("1.5"); Not valid as number is integer or double

		/*
		 * List[] array = new ArrayList[2]; //Gives runtime exception will be discuss in
		 * invariance array[0]= new ArrayList<>(); array[1]= new LinkedList<>();
		 */

		// GenericsDemo<List> list1 = new GenericsDemo<>(); //List or its Sub type is
		// good and not a subtype of serializable

		// Raw type demo:
		// rawTypeTest();

		List<String> strList1 = Arrays.asList("a", "b", "c");
		List<String> strList2 = Arrays.asList("b", "c", "d");
		//getCommonElementsCount(strList1, strList2); // When method is too generic go for unbounded wildcard

		// Wildcard
		getCommonElementsCountWithWildcard(strList1, strList2); 	//Uses unbounded wildcards

		/*
		 * Container<?> someStore = stringStore; 
		 * Object object = someStore.get();
		 * System.out.println("Stored element: " + object);
		 */

		/*
		  List<Integer> intList1 = Arrays.asList(1, 2); List<Integer> intList2 =
		  Arrays.asList(3, 4); 
		  invalidAggregate(intList1, intList2, new ArrayList());
		 */

		// go(new ArrayList<Integer>());
		// go(new Integer[1]);
		// genericMethodsDemo();
		 boundedWildcards();
	}

	static void boundedWildcards() {
		System.out.println("\n\nInside boundedWildcards ...");
		List<Integer> intList = Arrays.asList(11, 21, 31);
		display(intList);
		List<Double> doubleList = Arrays.asList(11.5, 21.5, 31.5);
		display(doubleList);

		// Pass a List<String> too!!
		List<Number> numList = new ArrayList<>();
		aggregateWithConsumer(intList, doubleList, numList);
		System.out.println("numList: " + numList);

		Collections.addAll(new ArrayList<Object>(), 1, 2);
		Collections.copy(numList, doubleList);
		System.out.println("numList after copy: " + numList);
		System.out.println("Collections.disjoint: " + Collections.disjoint(intList, doubleList));

		// Type argument inference is Integer with wildcard type version of replaceAll!
		GenericsDemo.replaceAll(numList, 11.5, 44);
		System.out.println("numList: " + numList);

		// ArrayList<Number> numList2 = new ArrayList<>(intList);
	}

	// Item 28: If Type parameter will be used only once, then go with wildcard
	// Replace unbounded type parameter with unbounded wildcard
	// Replace
	public static <E3, E1 extends E3, E2 extends E3> void aggregateWithConsumer2(List<E1> l1, List<E2> l2,
			List<E3> l3) {
		l3.addAll(l1);
		l3.addAll(l2);
	}

	// Renaming to aggregate leads to compiler error due to type erasure
	// e.g., l1 --> List<Integer, l2 --> List<Double>
	public static <E> void aggregateWithConsumer(List<? extends E> l1, List<? extends E> l2, List<? super E> l3) {
		l3.addAll(l1);
		l3.addAll(l2);
	}

	/*
	 * static <T> boolean replaceAll(List<? super T> list, T oldVal, T newVal) { for
	 * (int i = 0; i < list.size(); i++) { if (oldVal.equals(list.get(i)))
	 * list.set(i, newVal); } return true; }
	 */

	// Demonstrates exact match as it both produces & consumes data
	static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) {
		for (int i = 0; i < list.size(); i++) {
			if (oldVal.equals(list.get(i)))
				list.set(i, newVal);
		}
		return true;
	}

	/*
	 * static <T extends Number> void display(List<T> list) { for (Number element :
	 * list) { System.out.println("display()/element: " + element); } }
	 */

	// Changing to super will give compiler error as with super
	// List<Object> can be passed and here Number is the type in for-loop.
	// Would work if type in for-loop is changed to Object
	static void display(List<? extends Number> list) {
		for (Number element : list) {
			System.out.println("display()/element: " + element/* .intValue() */);
		}
		// list.add(22);
	}

	// Demonstrates:
	// (a) Type argument inference via method arguments & target type
	// (b) Explicit type argument specification
	// (c) Generic Constructor
	// (d) aggregate method fix from wildcard demo

	private static void genericMethodsDemo() {
		System.out.println("\nInside genericMethodsDemo:");

		typeArgInference(22.0);
		typeArgInference("Java");

		// Compile-time type-safety benefit in a generic method
		// Double doubleVal = typeArgInference1("Java");

		// Compile-time type-safety benefit in a generic method ~ wrong arguments
		Integer[] na = new Integer[100];
		Collection<Integer> cs = new ArrayList<>(); // Show with Number, String
		arrayToCollection(na, cs);

		// Type argument inference via target type
		String strVal = typeArgInferenceFromTargetType1();
		// Compiler places implicit Integer cast. But, method returns string!!
		//Integer intVal = typeArgInferenceFromTargetType1();

		// Type arg inference in method invocation context ~ works from Java 8 (show for
		// Java 7)
		GenericsDemo.targetTypeInvoker1(typeArgInferenceFromTargetType2());
		GenericsDemo.targetTypeInvoker1(new ArrayList<>()); // Eclipse Mars showing incorrect type arg
		GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2()); // Infers as Object
		List<String> strList = GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2());
		GenericsDemo.targetTypeInvoker2(new ArrayList<>());
		List<String> strList2 = GenericsDemo.targetTypeInvoker2(new ArrayList<>());

		// Inferring most specific super-type
		Serializable obj = typeArgInference3("", new ArrayList());
		AbstractCollection c = typeArgInference4(new ArrayList(), new HashSet());

		GenericsDemo.<String>uselessGenericMethod(); // type witness

		// Explicit Type Argument Specification: Type witness. Comment out Generic
		// constructor!!
		//GenericsDemo.<GenericsDemo>typeArgInference(new GenericsDemo());

		// Type arg for both constructor & new expression inference:
		// (i) inferred from constructor argument. If that's not possible then
		// (ii) context comes into play, e.g., target type or method invocation content
		
		new GenericsDemo<Number>(12.0); // T is Number, E is Double
		new GenericsDemo<>(12.0); // T & E are Double
		new <Double>GenericsDemo<Number>(12.0); // Type witness!!
		//new <Double>GenericsDemo<>(12.0); // Could have inferred from arg
		GenericsDemo<Number> gd = new GenericsDemo<>(12.0); // To avoid invariance, smartly infers Number for <> rather
															// than Double

		List<Integer> intList1 = Arrays.asList(1, 2);
		List<Integer> intList2 = Arrays.asList(3, 4);
		List<Integer> intList3 = new ArrayList<>();
		aggregate(intList1, intList2, intList3);
		System.out.println("intList3: " + intList3);

		// Invariance Workaround
		// GenericsDemo.invarianceWorkaround(new ArrayList<String>());
		 GenericsDemo.invarianceWorkaround(new ArrayList<Number>()); // Integer
		List<Integer> intList5 = new ArrayList<>();
		//GenericsDemo.invarianceWorkaround(intList5, 23);
		// GenericsDemo.invarianceWorkaround(intList5);
		Integer data = intList5.get(0);
	}

	// Invariance workaround ~ For harmless scenarios where type safety is not a
	// concern
	static <T extends Number> void invarianceWorkaround(List<T> list/*, T element*/) {
		// list.add(new Double(23.3));

		// T element = (T) new Double(23.3); // typically element of type T will be a
		// method parameter
		//list.add(element);
	}

	public static <E> void aggregate(List<E> l1, List<E> l2, List<E> l3) {
		l3.addAll(l1);
		l3.addAll(l2);
	}

	static <T> void uselessGenericMethod() {
		T t = (T) new Integer(2);
		System.out.println("typeWitness: " + t.getClass().getName());
	}

	static <T> T typeArgInference4(T object1, T object2) {
		System.out.println("Most specific type argument inferred: " + object2.getClass().getName());
		return object1;
	}

	static <T> T typeArgInference3(T object1, T object2) {
		System.out.println("Most specific type argument inferred: " + object2.getClass().getName());
		return object1;
	}

	static <T> List<T> targetTypeInvoker2(List<T> list) {
		return list;
	}

	// Type argument inference via target type
	public static <T> List<T> typeArgInferenceFromTargetType2() {
		List<String> list = new ArrayList<>();
		list.add("abc");

		return (List<T>) list;
	}

	// Type argument inference via target type
	public static <T> T typeArgInferenceFromTargetType1() {
		return (T) "abc"; // T would be Object after type erasure
	}

	static <T> void arrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // Correct
		}
	}

	public static <T> void typeArgInference(T object) {
		System.out.println("Type Argument:" + object.getClass().getName());
	}

	public static <T> T typeArgInference1(T object) {
		System.out.println("Type Argument: " + object.getClass().getName());
		return object;
	}

	static void targetTypeInvoker1(List<String> list) {
		for (String s : list) {
			System.out.println("Element: " + s);
		}
	}

	// Invariance
	static void go(List<Number> list) {
	}

	// Covariance
	static void go(Number[] list) {
		list[0] = 24.4;
	}

	public static void invalidAggregate(List<?> l1, List<?> l2, List<?> l3) {
		// l3.addAll(null); // null uses class level type parameter in this case
		// addAll();
		// l3.addAll(l2);
	}

	public static int getCommonElementsCountWithWildcard(List<?> list1, List<?> list2) {
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}
		}
		System.out.println("Common elements count: " + count);
		return count;
	}

	public static int getCommonElementsCount(List list1, List list2) {
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}
		}
		System.out.println("Common elements count: " + count);
		return count;
	}

	private static void rawTypeTest() {
		System.out.println("\n\nInside rawTypeTest ...");
		int ISBN = 1505297729;
		List<Double> prices = new ArrayList<>();

		HalfIntegrator.getPrice(ISBN, prices);
		Double price = prices.get(0); // Will give run time error Due to class cast exception
	}
	/*
	 * public void go(T list) { list.add(0, new Object()); }
	 */
}

class HalfIntegrator {

	public static void getPrice(int ISBN, List prices) {
		prices.add(45);
	}

}

interface Container<T> {
	void set(T a);

	T get();
}

class Store<T> implements Container<T> {

	private /* static */ T a; // Gives error cannot be static.

	@Override
	public void set(T a) {
		this.a = a;
	}

	@Override
	public T get() {
		return a;
	}

}