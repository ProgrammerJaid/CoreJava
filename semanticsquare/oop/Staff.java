package com.semanticsquare.oop;

	public class Staff extends User {
		
		public int id = 2;		
		public void printId() {
			System.out.println("id: " + id);
			System.out.println("super.id: " + super.id);
		}
		
		public void printUserType() {
			System.out.println("Staff");
		}
		
		public Staff() {
			userType = "Staff";
			System.out.println("Staff Constructor 1");
		}
		
		public Review postAReview(String reviewText) {
		   System.out.println("Staff: postAReview");
		   Review review = super.postAReview(reviewText);//it calls superClass postAReview method
		   review.setApproved(true);
		   return review;
		}
		
		public static void staticMethod() {
			System.out.println("\nStaff: staticMethod");
		}
		
		//public void finalMethod() {}	
		public Staff(int id) {
			this();				//invoking default constructor
			this.id=id;
			System.out.println("Staff Constructor 2");
		}
		
}
