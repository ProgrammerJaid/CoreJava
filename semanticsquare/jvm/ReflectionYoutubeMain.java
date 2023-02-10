package com.semanticsquare.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectionYoutubeMain {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		//reflectionBasicAcessingMethods();
		reflectionMethodInvocation();
	}

	private static void reflectionMethodInvocation() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class llamaClass = Llama.class;
		
		Constructor constructor=llamaClass.getConstructor(String.class,int.class,String.class,boolean.class);
		
		Llama llama=(Llama) constructor.newInstance("bob",2,"red",true);
		System.out.println(llama);
		//Method method=llamaClass.getMethod("wool");
		//method.invoke(llama);
		
		
		//Accessing private method Using Reflection
		/*Method method = llamaClass.getDeclaredMethod("eat");
		method.setAccessible(true);
		method.invoke(llama);
		
		for(Method currentMethod: llamaClass.getDeclaredMethods()) {
			
			if(currentMethod.getParameterCount()==0) {
				currentMethod.setAccessible(true);
				System.out.println(currentMethod.invoke(llama));
			}
		}*/
		
		//Changing values of field
		Field eyeField=llamaClass.getDeclaredField("eyeCount");
		eyeField.setAccessible(true);
		eyeField.set(llama, 30);
		System.out.println(llama);
	}

	private static void reflectionBasicAcessingMethods() {
		 //Class dogClass = Dog.class; System.out.println(dogClass.getName());
		 

		// Using dog object
		Dog dog = new Dog("Bob", 4);
		Class dogClass = dog.getClass();

		System.out.println("Class Name: " + dogClass.getName());
		System.out.println("Interface? " + dogClass.isInterface());

		System.out.println("\nConstructors: ");
		Constructor[] constructors = dogClass.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println("constructor name:" + constructor.getName());
			System.out.println("---params---");
			if (constructor.getParameterCount() == 0) {
				System.out.println("no-arg constructor");
			} else {
				Parameter[] parameters = constructor.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println(parameter.getName() + " : " + parameter.getType());
				}
			}
		}
		int i = 1;
		for (Method method : dogClass.getMethods()) { // getMethod gives all methods in sub and super class but does not
														// show private methods
			System.out.println("Method #" + i + " " + Modifier.toString(method.getModifiers()) + " " + method.getName()
					+ " " + method.getReturnType().getName() + "-" + Arrays.toString(method.getParameters()));
			i++;
		}

		System.out.println("\n\n");
		Method[] declaredMethods = dogClass.getDeclaredMethods(); // getDeclared Method gives private method also but
																	// does not give superclass methods
		for (int j = 0; j < declaredMethods.length; j++) {
			System.out.println("Method #" + (j + 1) + " " + Modifier.toString(declaredMethods[j].getModifiers()) + " "
					+ declaredMethods[j].getName() + " " + declaredMethods[j].getReturnType().getName() + "-"
					+ Arrays.toString(declaredMethods[j].getParameters()));
		}
		//print the fields
		Field[] fields = dogClass.getDeclaredFields();
		for(Field field: fields) {
			System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType());
		}
	}
}
