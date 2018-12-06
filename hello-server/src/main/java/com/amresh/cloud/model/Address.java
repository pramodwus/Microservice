package com.amresh.cloud.model;

public class Address {
	
	private String city;
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
