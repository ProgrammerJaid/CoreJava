package com.semanticsquare.oop.InterfaceDemo;

public class TestClient {
	   public static int getVal() {
	       return 42;
	   }
	 
	   public static void main(String[] args) {
	       C c = new X();
		   c.foo();
		   c.bar();
		   c.foobar();
		   
		   C clone = ((X)c).clone();
		   if (clone != c) {
		      System.out.println("Clone created!!");
		   }
	   }
	}
