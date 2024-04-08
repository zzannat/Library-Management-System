package com.model;

import org.springframework.data.annotation.Id;

public class Publisher {

	@Id
    private String id;
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	
	
	public Publisher() {
		super();
	}

	public Publisher(String name, String streetAddress, String city, String state, String postalCode,
			String country) {
		super();
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
