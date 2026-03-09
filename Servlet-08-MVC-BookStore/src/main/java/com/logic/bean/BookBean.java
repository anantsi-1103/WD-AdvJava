package com.logic.bean;

import java.io.Serializable;

// implement serializable interface
public class BookBean implements Serializable {

	// var must be private
	private Integer id;
	private String name, author;
	private Integer price;

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	// zero parameter constructor
	public BookBean() {

	}

	// to string method
	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

}
