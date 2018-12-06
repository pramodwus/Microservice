package com.amresh.cloud.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Address description")
public class Address {
	
	@ApiModelProperty(notes = "city is properties of the Address.", dataType="java.lang.String" )
	private String city;
    
	@ApiModelProperty(notes = "country is properties of the Address.", dataType="java.lang.String" )
	private String country;
    
    public Address(){}
    
    
    public Address(String city, String country) {
		this.city = city;
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public Address setCity(String city) {
		this.city = city;
		return this;
	}


	public String getCountry() {
		return country;
	}


	public Address setCountry(String country) {
		this.country = country;
		return this;
	}




	

}
