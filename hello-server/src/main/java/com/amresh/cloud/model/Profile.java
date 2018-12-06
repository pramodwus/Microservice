package com.amresh.cloud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profileDetails")
public class Profile {
	
	@Id
	private String id;
    
	private String name;
    
	@Indexed(direction = IndexDirection.ASCENDING)
    private int like;
    
	private Address address;
    
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
