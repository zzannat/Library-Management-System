package com.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Member {
	@Id
    private String id;
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String membershipType;
	private LocalDate  membershipDate;	
	private LocalDate  expiryDate;

	
		
	public Member() {
		super();
	}


	public Member(String name, String streetAddress, String city, String state, String postalCode,
			String country, String membershipType, LocalDate  membershipDate, LocalDate  expiryDate) {
		super();
	
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.membershipType = membershipType;
		this.membershipDate = membershipDate;
		this.expiryDate = expiryDate;
	
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
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public LocalDate  getMembershipDate() {
		return membershipDate;
	}
	public void setMembershipDate(LocalDate  membershipDate) {
		this.membershipDate = membershipDate;
	}
	public LocalDate  getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate  expiryDate) {
		this.expiryDate = expiryDate;
	}

	

}
