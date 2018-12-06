package com.amresh.cloud.model;

public class Comment {
	
	private String userName;
    private int rating;
    private boolean isGood;
    
    
    
    public Comment() {
		
	}


	public Comment(String userName, int rating, boolean isGood) {
		
		this.userName = userName;
		this.rating = rating;
		this.isGood = isGood;
	}
    
    
	public String getUserName() {
		return userName;
	}
	public Comment setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public int getRating() {
		return rating;
	}
	public Comment setRating(int rating) {
		this.rating = rating;
		return this;
	}
	public boolean isGood() {
		return isGood;
	}
	public Comment setGood(boolean isGood) {
		this.isGood = isGood;
		return this;
	}
    
    
    
    
    


}
