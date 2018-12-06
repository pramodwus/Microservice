package com.amresh.cloud.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Profile description")
public class Profile {
	
	
	@ApiModelProperty(notes = "id is properties of the Profile. Which is unique", dataType="java.lang.String" )
	private String id;
	
	@ApiModelProperty(notes = "name is properties of the Profile.", dataType="java.lang.String" )
	private String name;
   
	
	@ApiModelProperty(notes = "like is properties of the Profile.", dataType="java.lang.String" )
	private int like;
	
	@ApiModelProperty(notes = "address is properties of the Profile.", dataType="com.amresh.cloud.model.Address" )
	private Address address;
	
	@ApiModelProperty(notes = "address is properties of the Profile.", dataType="java.util.List<Comment>" )
	private List<Comment> comments;
	
	
	
	public Profile() {
		
	}
/**
 * 
 * @param id
 * @param name
 * @param like
 * @param address
 * @param comments
 */
	public Profile( String name, int like, Address address, List<Comment> comments) {
		this.name = name;
		this.like = like;
		this.address = address;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public Profile setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Profile setName(String name) {
		this.name = name;
		return this;
	}

	public int getLike() {
		return like;
	}

	public Profile setLike(int like) {
		this.like = like;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public Profile setAddress(Address address) {
		this.address = address;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Profile setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}
	
	
	
	
	
	
	
	
	
    

}
