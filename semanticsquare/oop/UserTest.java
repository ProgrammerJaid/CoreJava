package com.semanticsquare.oop;

public class UserTest {
	public void printUserType(User u) {  //polymorphism
		   u.printUserType();
		}
		
	
	public void approveReview(Staff s) {
		if (s instanceof Editor) {
			((Editor) s).approveReview(); 
        } else {
        	System.out.println("Invalid object passed!!");
        }
	}
	
		public static void main(String[] args) {
			// Part 1
			/*User user = new User();
			User staff = new Staff();
			User editor = new Editor();
			staff.postAReview("");
			((Staff)staff).printId();	//used for displaying fields
			/*UserTest ut = new UserTest();
			ut.printUserType(user);
			ut.printUserType(staff);
			ut.printUserType(editor);*/
			
			// Part 2
			//editor.approveReview();  //user type data cannot find approve review
			//editor.postAReview();
			//editor.saveWebLink();    //this is imp.,its start searching
									 //from editor for a method always
									 //since object reference is of user type
									 //method binding is done with user @ compile time

			// Casting & instanceof demo
			/*UserTest ut = new UserTest();
			ut.approveReview(new Staff());
			ut.approveReview(new Editor());//object type matters
		*/
			
			//User staff = new Editor();
			//staff.staticMethod();		//early binding with User(as User is reference type).
			//((Staff)staff).staticMethod();	//for accessing staff class static method			
		
		// Overriding of instance variables demo
				User staff = new Staff(3);
				//System.out.println("User type: " + staff.userType); // early binding
				//staff.displayUserInfo();// comparison of field hiding & field overriding effect
				
				
		}
		
}
