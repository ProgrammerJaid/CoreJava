package com.semanticsquare.oop;

public class Review {
	
	private String reviewText;
	private boolean approved;
	
	public Review (String reviewText) {		//user postAReview
		this.reviewText = reviewText;
	}
	
	public boolean isApproved() {		
		return approved;
	}
	
	public void setApproved(boolean approved) {	
		this.approved = approved;
	}
}
