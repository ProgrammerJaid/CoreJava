package com.semanticssquare.basics;

public class UserTest {
	public void printUserType(User u) {
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
		
		//User user = new User();
		//Staff staff = new Staff();
		//Editor editor = new Editor();
		
		/*UserTest ut = new UserTest();
		ut.printUserType(user);
		ut.printUserType(staff);
		ut.printUserType(editor);*/
		
		// Part 2
//		editor.approveReview();
//		editor.postAReview();
//		editor.saveWebLink();
		// Casting & instanceof demo
		
		UserTest ut = new UserTest();
		//ut.approveReview(new Staff());
		ut.approveReview(new Editor());
	}
}
