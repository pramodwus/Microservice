package com.amresh.cloud.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Comment description")
public class Comment {
	
	
	@ApiModelProperty(notes = "userName is properties of the Comment.", dataType="java.lang.String" )
	private String userName;
   
	@ApiModelProperty(notes = "rating is properties of the Comment.", dataType="java.lang.Integer" )
	private int rating;
    
	@ApiModelProperty(notes = "isGood is properties of the Comment.", dataType="java.lang.Boolean" )
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
