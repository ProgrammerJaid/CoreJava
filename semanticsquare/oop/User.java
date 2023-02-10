package com.semanticsquare.oop;

public class User {
	public int id = 1;		//hidden field accessed by using super
	public String userType = "User";
	   public void printUserType() {
		   System.out.println("User");
	   }
	   
	   public void saveWebLink() {
		   System.out.println("User: saveWebLink");
		   //postAReview();
	   }
	   public Review postAReview(String reviewText) {
		   System.out.println("User: postAReview");
		   Review review = new Review(reviewText);
		   return review;
	   }
	   
	   public void displayUserInfo() {
		   
		   System.out.println("\nPrinting User Info: ");
		   System.out.println("id: " + id);
		   System.out.println("userType: " + userType);
	   }
	   
	 //Method Binding Demo
	 public static void staticMethod() {
	 		System.out.println("\nUser: staticMethod");
	 }
	   
	   public final void finalMethod() {}
	   
	   public User() {
		   System.out.println("User Constructor");
	   }

}
