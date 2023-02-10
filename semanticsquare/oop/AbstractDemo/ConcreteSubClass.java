package com.semanticsquare.oop.AbstractDemo;

public class ConcreteSubClass extends AbstractSubClass {
	   @Override							//must override all abstract method
	   void test2() {
		   System.out.println("test2");
	   }
	   @Override
	   void test3() {
		   System.out.println("test3");
	   }

	   public static void main(String[] args) {
		   ConcreteSubClass concrete = new ConcreteSubClass();
		   concrete.test1();
		   concrete.test2();
		   concrete.test3();
		   //AbstractSuperClass test = new AbstractSuperClass();
	   }
	}
