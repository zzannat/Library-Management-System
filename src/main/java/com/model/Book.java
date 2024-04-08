package com.model;

import org.springframework.data.annotation.Id;

public class Book {
	@Id
    private String id;
	private String author;
	private String title;
	private double price;
	private int available;

	
		
	public Book() {
		super();
		
	}

	public Book(String author, String title, double price, int available) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		this.available = available;
	}
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
		

}
